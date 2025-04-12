# java-journey

A code journal documenting my Java programming journey through practical examples and projects.

## Table of Contents

- [Chat program overview](#chat-program-overview)

## Chat program overview

Each client has to know about servre. and the server has to know about all the clients.
![Alt text](../../ressources/chatProgram_howItWorks.jpg "Chat Program: how it works")

### Connecting, sending, and receiving

The three thingswe have to learn to get the client working are:

- How to establish the initial _connection_ between the client and server.
- How to _receive_ message from the server.
- How to _send_ message to ther server.

1. Connect

To talk to an other machine we need an object that represents a network connection between two machines. we ca open a java.nio.channels. SocketChannel to give us this connection object.
Most important that this two machine know how to communicate with each others.in other word, how to send bits to each others.
to make a connection you need to know two thins about the server: where it is and witch port it's running on.in other words : IP adress and TCP port number.

```
    InetSocketAddress serverAdress = new InetSocketAddress("196.164.1.103", 5000);
    SocketChannel socketChannel = SocketChannel.open(serverAdress);
```

InetSocketAddress: Represents the full adress of the machine we want to connect to.
SocketChannel: We can use a SocketChannel to talk to another machine.
open(serverAdress): You don't use a constructor to create a new SocketChannel, you call the static open() method. this will create a new SocketChannel and connect it to the adress you give it.

_A coonection means the two machines have information about each other, including network(IP Adress) and TCP Port._

2. Receive

You can use BufferedReader just like you did when you were reading from a file. the difference is that the underlying connection stream is connected to a _Channel_ rather than a _File_!

- Make connection to the server

```
    InetSocketAddress serverAdress = new InetSocketAddress("127.0.0.1", 5000);
    SocketChannel socketChannel = SocketChannel.open(serverAdress);
```

- Create or get a Reader from the connection

```
    Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
```

- Make a BufferedReader and read!

```
    BufferedReader bufferedReader = new BufferedReader(reader);
    String message = bufferedReader.readLine();
```

![Alt text](../../ressources/recieve_ChatProgram.jpg "Recieve Step")

3. Send
