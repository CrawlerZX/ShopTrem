package jogo.DAO;

import java.util.ArrayList;

public class FaseModel {

    private int id_fase;
    private String nome;
    public ArrayList<CenarioModel> listCenario;

    public FaseModel() {

        this.listCenario = new ArrayList<CenarioModel>();
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_fase() {
        return id_fase;
    }

    public String getNome() {
        return nome;
    }
}
