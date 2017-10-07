package Teste.sockets;

import Teste.sockets.Client.Client;

import java.io.DataInputStream;
import java.io.IOException;

public class ClienteReceive extends Thread {

    public void run(){

        try {
            ClienteMain.s_socket.accept();

            int n = 1000;
            while (n > 0){

                String s = "";
                s = ClienteMain.input.readUTF();
                System.out.println("Outro: " + s);

                n--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
