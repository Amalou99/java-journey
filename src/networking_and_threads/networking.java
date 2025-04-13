package networking_and_threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class networking {

    public static void main(String[] args) throws IOException {

        /*
         * Recieve Sep
         */
        receiveMessageWithChannel();

        /*
         * Send Step
         */
        sendMessageWIthChannel();
    }

    public static void receiveMessageWithChannel() throws IOException {

        InetSocketAddress serverAdress = new InetSocketAddress("127.0.0.1", 5000);
        SocketChannel socketChannel = SocketChannel.open(serverAdress);

        Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);

        BufferedReader bufferedReader = new BufferedReader(reader);
        String message = bufferedReader.readLine();
    }

    public static void sendMessageWIthChannel() throws IOException {
        InetSocketAddress serverAdressRecieve = new InetSocketAddress("127.0.0.1", 5000);
        SocketChannel socketChannelRecieve = SocketChannel.open(serverAdressRecieve);

        Writer writer = Channels.newWriter(socketChannelRecieve, StandardCharsets.UTF_8);

        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println("message to send");
        printWriter.print("another message");
    }

    public static void writeAndReadWithSocket() throws UnknownHostException, IOException {

        Socket chatSocket = new Socket("127.0.0.1", 5000);

        InputStreamReader in = new InputStreamReader(chatSocket.getInputStream());

        BufferedReader reader = new BufferedReader(in);
        String message = reader.readLine();

        PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
        writer.println("message to send");
        writer.println("another message");

    }
}
