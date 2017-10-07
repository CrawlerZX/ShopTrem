package Teste.sockets.Server;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("Server: ");

        Receive rec= new Receive();
        rec.start();

        Sender send = new Sender();
        send.start();
    }
}
