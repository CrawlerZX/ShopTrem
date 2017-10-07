package Teste.sockets.Server;


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive extends Thread {

    ServerSocket s_socket;
    Socket c_socket;

    public void run(){

        try{

            s_socket = new ServerSocket(9999, 10);

            c_socket = s_socket.accept();

            DataInputStream input = new DataInputStream(c_socket.getInputStream());

            int n = 1000;
            while (n > 0) {

                String s = input.readUTF();
                System.out.println();
                System.out.print("Outro: " + s);

                n--;
            }

            c_socket.close();

        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }
}
