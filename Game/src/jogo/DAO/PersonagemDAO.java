package jogo.DAO;

import jogo.Models.PersonagemModel;

import java.sql.*;
import java.util.ArrayList;

public class PersonagemDAO {

    public static PersonagemModel getPersonagem() throws SQLException {

        Connection con = null;

        PersonagemModel obj = new PersonagemModel();

        try {
            con = Conn.getConexao();
            PreparedStatement psmt = con.prepareStatement("select * from sprite where nome = 'person'");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()){
                obj.setId_sprite(rs.getInt("id_sprite"));
                obj.setNome(rs.getString("nome"));
                obj.setCaminho_sprite(rs.getString("Caminho_sprite"));
                obj.setNum_frames(rs.getInt("num_frames"));
                obj.setVelocidade(rs.getInt("velocidade"));
                obj.setDir_som_andando(rs.getString("dir_som_andando"));
                obj.setDir_som_correrendo(rs.getString("dir_som_correndo"));
            }

            return obj;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            con.close();
            return obj;
        }
    }
}
