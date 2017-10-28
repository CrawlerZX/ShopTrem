package jogo.DAO;

import jogo.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conn {

    public static String status = "Não conectou...";

//    private static final String USUARIO = "root";
//    private static final String SENHA = "root";
//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/game";
//    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static String USUARIO;
    private static String SENHA;
    private static String URL;
    private static String DRIVER;

    private static void LoadInfo() throws Exception {

        String[] tmp = new String[4];
        BufferedReader br = new BufferedReader(new FileReader(Utilities.getConfigPath()));
        try {
            int i = 0;
            while(br.ready()){
                String[] linha = br.readLine().split("=");
                tmp[i] = linha[1].trim();
                i++;
            }
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage() + " " + ex.getStackTrace());
        }
        finally {
            br.close();
        }

        USUARIO = tmp[0];
        SENHA = tmp[1];
        URL = tmp[2];
        DRIVER = tmp[3];

    }

    public static java.sql.Connection getConexao() throws Exception {

        LoadInfo();

        Connection connection = null;

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
            Conn.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() throws Exception {
        FecharConexao();
        return Conn.getConexao();
    }
}
