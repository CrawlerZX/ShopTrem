package jogo.DAO;

public class PersonagemDAO {

//    public static PersonagemModel getPersonagem() throws SQLException {
//
//        Connection con = null;
//
//        PersonagemModel persomModel = new PersonagemModel();
//
//        try {
//            con = Conn.getConexao();
//            PreparedStatement psmt = con.prepareStatement("select * from param p where p.item like \"%person%\";");
//
//            ResultSet rs = psmt.executeQuery();
//
//            while (rs.next()){
//                persomModel.setId_sprite(rs.getInt("id_sprite"));
//                persomModel.setNome(rs.getString("nome"));
//                persomModel.setDir_img(rs.getString("Caminho_sprite"));
//                persomModel.setNum_frame(rs.getInt("num_frames"));
//                persomModel.setVelocidade(rs.getInt("velocidade"));
//                persomModel.setDir_som_andando(rs.getString("dir_som_andando"));
//                persomModel.setDir_som_correrendo(rs.getString("dir_som_correndo"));
//            }
//
//            return persomModel;
//        }
//        catch (SQLException ex){
//            System.out.println(ex.getMessage());
//        } finally {
//            con.close();
//            return persomModel;
//        }
//    }
}
