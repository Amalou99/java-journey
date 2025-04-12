package networking_and_threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class networking {

    public static void main(String[] args) throws IOException {

        InetSocketAddress serverAdress = new InetSocketAddress("127.0.0.1", 5000);
        SocketChannel socketChannel = SocketChannel.open(serverAdress);

        Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);

        BufferedReader bufferedReader = new BufferedReader(reader);
        String message = bufferedReader.readLine();
    }
}
