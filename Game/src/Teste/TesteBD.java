package Teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteBD {

    public static void main(String[] args) {

        Connection connection = null;

        try {

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            String serverName = "127.0.0.1";    //caminho do servidor do BD

            String mydatabase = "game";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD

            String password = "root";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            String status;
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

        } catch (ClassNotFoundException e) {

            System.out.println("O driver expecificado nao foi encontrado.");

        } catch (SQLException e) {


            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

        }
    }

}
