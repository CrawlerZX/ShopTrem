package jogo;

import jogo.DAO.ConfigDAL;
import jogo.DAO.ConfigModel;
import jogo.DAO.FaseDAL;
import jogo.DAO.FaseModel;

public class Main {

    public static void main(String[] args) throws Exception {

        FaseModel obj = FaseDAL.getFase();

        System.out.println(obj.getNome());

    }
}
