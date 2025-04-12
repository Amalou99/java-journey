package networking_and_threads;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class networking {

    public static void main(String[] args) throws IOException {

        InetSocketAddress serverAdress = new InetSocketAddress("196.164.1.103", 5000);
        SocketChannel socketChannel = SocketChannel.open(serverAdress);
    }
}
