package jogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigDAL {

    public static ConfigModel getConfig() throws Exception {

        Connection conn = null;
        ConfigModel model = new ConfigModel();

        try {

            conn = Conn.getConexao();
            PreparedStatement psmt = conn.prepareStatement("select * from param");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()){

                model.setGame_janela_w					(rs.getInt("game.janela.w"));
                model.setGame_janela_h					(rs.getInt("game.janela.h"));

                model.setGame_thread_sleep_transition	(rs.getInt("game.thread.sleep.transition"));
                model.setGame_thread_sleep				(rs.getInt("game.thread.sleep"));

                model.setPerson_dir_img					(rs.getString("person.dir.img"));
                model.setPerson_num_frame				(rs.getInt("person.num.frame"));
                model.setPerson_vel						(rs.getDouble("person.vel"));
                model.setPerson_anim_duration			(rs.getInt("person.anim.duration"));
                model.setPerson_init_x					(rs.getDouble("person.init.x"));
                model.setPerson_init_y					(rs.getDouble("person.init.y"));

                model.setGuarda_dir_img					(rs.getString("guarda.dir.img"));
                model.setGuarda_num_frame				(rs.getInt("guarda.num.frame"));
                model.setGuarda_vel						(rs.getDouble("guarda.vel"));
                model.setGuarda_anim_duration			(rs.getInt("guarda.anim.duration"));
                model.setGuarda_rayvision				(rs.getInt("guarda.rayvision"));
                model.setGuarda_init_x					(rs.getDouble("guarda.init.x"));
                model.setGuarda_init_y					(rs.getDouble("guarda.init.y"));
            }

            return model;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            conn.close();
            return model;
        }
    }
}
