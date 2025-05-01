package networking_and_threads;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClientA {
    private JTextField outgoing;
    private PrintWriter writer;

    public void go() {
        // call the setUpNetworking() method
        // make a gui and register and assign to writer instance variable

        setUpNetworking();
        outgoing = new JTextField(20);

        JButton sendButton = new JButton("send");
        sendButton.addActionListener(e -> sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpNetworking() {
        // Open a socketChannel to the server
        // make a PrintWriter and assign to writer instance variable
        try {
            InetSocketAddress serverAdress = new InetSocketAddress("127.0.0.1", 5000);
            SocketChannel socketChannel = SocketChannel.open(serverAdress);

            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            System.out.println("Networking established.");
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        // get the text from the text field and
        // send it to the server using the writer (a PrinWriter)
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

}
