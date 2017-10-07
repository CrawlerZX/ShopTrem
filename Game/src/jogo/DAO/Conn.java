package jogo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conn {

    public static String status = "Não conectou...";

    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/game";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public Conn() {

    }

    public static java.sql.Connection getConexao() {

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
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Conn.getConexao();
    }
}
