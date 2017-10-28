package jogo;

import jogo.DAO.ConfigDAL;
import jogo.DAO.ConfigModel;

public class Main {

    public static void main(String[] args) throws Exception {

        ConfigModel obj = ConfigDAL.getConfig();
    }
}
