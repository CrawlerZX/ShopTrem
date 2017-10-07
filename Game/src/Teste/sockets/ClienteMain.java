package Teste.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteMain {

    public static Socket c_socket;
    public static ServerSocket s_socket;

    public static DataInputStream input;
    public static DataOutputStream output;

    public static void main(String[] args) throws IOException {

        c_socket = new Socket("127.0.0.1", 8888);
        s_socket = new ServerSocket(9999, 10);

        input = new DataInputStream(c_socket.getInputStream());
        output = new DataOutputStream(c_socket.getOutputStream());

        ClienteReceive receive = new ClienteReceive();
        ClienteSender sender = new ClienteSender();

        receive.start();
        sender.start();
    }
}
