package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * @author Crunchify.com
 */

public class client {

    public static void main(String[] args) throws IOException, InterruptedException {

        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

        log("Connecting to Server on port 1111...");

        byte[] message = new String("zhangxun").getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        crunchifyClient.write(buffer);

        log("sending: " + new String(message));
        buffer.clear();

//        crunchifyClient.close();
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
