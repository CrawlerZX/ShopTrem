package Teste.sockets.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Sender extends Thread {

    public Socket c_socket;

    public void run() {

        try {
            c_socket = new Socket("127.0.0.1", 8888);

            DataInputStream input = new DataInputStream(System.in);
            DataOutputStream output = new DataOutputStream(c_socket.getOutputStream());

            int n = 1000;
            while (n > 0){
                String sender = "";

                System.out.println("Envie uma mensagem: ");
                sender = input.readUTF();

                output.writeUTF(sender);

                n--;
            }

            c_socket.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
