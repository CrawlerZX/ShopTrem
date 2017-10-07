package Teste.sockets;

import java.io.DataInputStream;

public class ClienteSender extends Thread {

    public void run(){

        try {

            DataInputStream inputSys = new DataInputStream(System.in);

            int n = 1000;
            while (n > 0){

                String s = "";
                System.out.println("Escreva algo... \n");
                s = inputSys.readUTF();

                ClienteMain.output.writeUTF(s);

                n--;
            }
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }
}
