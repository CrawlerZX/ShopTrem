package Teste.sockets.Client;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Cliente: ");

        Sender send = new Sender();
        send.start();

        Receive rec= new Receive();
        rec.start();
    }
}
