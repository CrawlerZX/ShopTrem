package jogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FaseDAL {

    public static FaseModel getFase() throws SQLException {

        Connection conn = null;
        FaseModel model = new FaseModel();

        try {

            conn = Conn.getConexao();
            PreparedStatement psmt = conn.prepareStatement("select * from fase inner join cenario on cenario.id_fase = fase.id_fase;");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()){

                model.setId_fase(rs.getInt("id_fase"));
                model.setNome(rs.getString("nome"));

                CenarioModel cen = new CenarioModel();
                cen.setId_cenario(rs.getInt		("id_cenario"));
                cen.setId_fase(rs.getInt		("id_fase"));
                cen.setDir_trem(rs.getString	("dir.trem"));
                cen.setDir_parede(rs.getString	("dir.parede"));
                cen.setNm_guarda(rs.getInt		("nm_guarda"));
                cen.setNm_cliente(rs.getInt		("nm_cliente"));
                cen.setPos_guarda1(rs.getString	("pos.guarda1"));
                cen.setPos_guarda2(rs.getString	("pos.guarda2"));
                cen.setPos_guarda3(rs.getString	("pos.guarda3"));
                cen.setPos_guarda4(rs.getString	("pos.guarda4"));
                cen.setPos_guarda5(rs.getString	("pos.guarda5"));
                cen.setPos_guarda6(rs.getString	("pos.guarda6"));
                cen.setPos_guarda7(rs.getString	("pos.guarda7"));
                cen.setPos_guarda8(rs.getString	("pos.guarda8"));
                cen.setPos_guarda9(rs.getString	("pos.guarda9"));
                cen.setPos_guarda10(rs.getString("pos.guarda10"));
                cen.setPos_cliente1(rs.getString("pos.cliente1"));
                cen.setPos_cliente2(rs.getString("pos.cliente2"));
                cen.setPos_cliente3(rs.getString("pos.cliente3"));
                cen.setPos_cliente4(rs.getString("pos.cliente4"));
                cen.setPos_cliente5(rs.getString("pos.cliente5"));
                cen.setPos_cliente6(rs.getString("pos.cliente6"));

                model.listCenario.add(cen);
            }

            return model;
        }
        catch (SQLException ex){
            throw new SQLException(ex.getMessage());
        } finally {
            conn.close();
            return model;
        }
    }
}
