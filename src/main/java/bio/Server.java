package bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用多线程的方式进行处理
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ExecutorService newCashedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(15004);
        System.out.println("服务器启动!");
        while (true) {
            // 获取一个套接字(阻塞)
            final Socket socket = serverSocket.accept();
            System.out.println("来了一个新客户端！");
            newCashedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 业务处理
                    handler(socket);
                }
            });
        }
    }

    /*
     * 读取数据
     * 
     * @param socket
     */
    private static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                // 读取数据 阻塞
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
                outputStream.write("got msg, response OK".getBytes());
                outputStream.flush();
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                System.out.println("socket关闭");
                socket.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
