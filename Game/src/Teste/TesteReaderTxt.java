package Teste;

import jogo.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TesteReaderTxt {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(Utilities.getConfigPath()));
        while(br.ready()){
            String[] linha = br.readLine().split("=");
            System.out.println(linha[1]);
        }
        br.close();

    }
}
