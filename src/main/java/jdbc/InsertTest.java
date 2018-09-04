package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import serial.SnowflakeIdWorker;

public class InsertTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Set<HostAndPort> set = new HashSet<HostAndPort>();
        HostAndPort hap = new HostAndPort("172.31.176.81", 6379);
        set.add(hap);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        final JedisCluster jedisCluster = new JedisCluster(set, jedisPoolConfig);

        int THREADS_COUNT  = 50;
        final SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    final String url = "jdbc:mysql://172.31.176.82:3309/ord";
                    final String name = "com.mysql.jdbc.Driver";
                    final String user = "root";
                    final String password = "123456";
                    Connection conn = null;
                    try {
                        Class.forName(name);//指定连接类型
                        conn = DriverManager.getConnection(url, user, password);//获取连接
                        if (conn != null) {
                            System.out.println("获取连接成功");
                            insert(conn, jedisCluster, snowflakeIdWorker);
                        } else {
                            System.out.println("获取连接失败");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        } //等待 所有 累加 线程 都 结束
    }

    public static void insert(Connection conn, JedisCluster jedisCluster, SnowflakeIdWorker snowflakeIdWorker ) {
        // 开始时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO user(id, user_name,password,email,mobile,status,add_time,update_time) VALUES ";
        try {
            // 保存sql后缀
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            // 外层循环，总提交事务次数"
            for (int i = 1; i <= 10000; i++) {
//                suffix = new StringBuffer();
                PreparedStatement pst = (PreparedStatement) conn.prepareStatement(prefix);//准备执行语句
                StringBuffer suffix = new StringBuffer();
                // 第j次提交步长
                long start = System.currentTimeMillis();
                for (int j = 1; j <= 1000; j++) {
                    // 构建SQL后缀
                    long id = jedisCluster.incr("USER:ID:INCR");
                    suffix.append("(" + id + ",'" + snowflakeIdWorker.nextId() + "','" + "e10adc3949ba59abbe56e057f20f883e" +
                            "','" + snowflakeIdWorker.nextId() + "','" + snowflakeIdWorker.nextId() +  "',1, now(), now()" + "),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst = (PreparedStatement) conn.prepareStatement(sql);//准备执行语句
//                pst.addBatch(sql);
                // 执行操作
                pst.executeUpdate(sql);
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
                long end = System.currentTimeMillis();
                System.out.println("cost:" + (end -start));
                pst.close();
            }
            // 头等连接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("1000万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }
}
