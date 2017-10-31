package jogo;

import jogo.DAO.CenarioModel;

import java.util.ArrayList;

public class Fase {

    private ArrayList<CenarioModel> cenarios;
    public int atual;
    public String nome;

    public Fase(String nome, ArrayList<CenarioModel> cenarios){

        this.cenarios = cenarios;
        this.atual = 0;
        this.nome = nome;
    }

    public void draw() {

        CenarioModel cena = cenarios.get(atual);

        cena.trem.draw();
        Game.cliente.draw();
        Game.person.draw();
        Game.guarda.draw();
        cena.parede_ex.draw();
    }
}
