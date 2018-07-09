package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import serial.SnowflakeIdWorker;

public class InsertTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        int THREADS_COUNT  = 10;

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    final String url = "jdbc:mysql://172.31.176.85/ord";
                    final String name = "com.mysql.jdbc.Driver";
                    final String user = "root";
                    final String password = "root";
                    Connection conn = null;
                    try {
                        Class.forName(name);//指定连接类型
                        conn = DriverManager.getConnection(url, user, password);//获取连接
                        if (conn != null) {
                            System.out.println("获取连接成功");
                            insert(conn);
                        } else {
                            System.out.println("获取连接失败");
                        }
                    }catch (Exception e){

                    }
                }
            });
            threads[i].start();
        } //等待 所有 累加 线程 都 结束
    }

    public static void insert(Connection conn) {
        // 开始时间
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO user(user_name,password,email,mobile,status,add_time,update_time) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            // 外层循环，总提交事务次数"
            PreparedStatement pst;
            for (int i = 1; i <= 100000; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 1000; j++) {
                    // 构建SQL后缀
                    suffix.append("('" + snowflakeIdWorker.nextId() + "','" + "e10adc3949ba59abbe56e057f20f883e" +
                            "','" + snowflakeIdWorker.nextId() + "','" + snowflakeIdWorker.nextId() +  "',1, now(), now()" + "),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst = (PreparedStatement) conn.prepareStatement(sql);//准备执行语句
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
//            pst.close();
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
