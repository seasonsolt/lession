package bio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class client{
    // 搭建客户端
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("127.0.0.1", 15004);
        OutputStream out = sock.getOutputStream();
        InputStream sin = sock.getInputStream();
        byte buf [] = new byte[512];
        buf = "zhangxun".getBytes();
        out.write(buf);
        out.flush();
        System.out.println("send ok ---> " + sin + "     Out: " + out);
        byte ibuf[] = new byte[512];
        int len = sin.read(ibuf);
        String s = new String(ibuf, 0, len-1);
        System.out.print(len + s);
        out.close();
        sin.close();
        sock.close();
        return;
    }

}