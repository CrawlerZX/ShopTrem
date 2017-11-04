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

    public static boolean aux = false;
    public void draw() {

        CenarioModel cena = cenarios.get(atual);

        cena.trem.draw();

        if(this.atual == 4) {
            Game.cliente.hide();
            Game.guarda.hide();
        }
        else  {
            Game.cliente.unhide();
            Game.guarda.unhide();
        }

        Game.cliente.draw();

        if(cena.getNm_guarda() > 0 && Game.guarda.isHide){
            String[] vetPos = cena.getPos_guarda1().split(";");
            Game.guarda.x = Integer.valueOf(vetPos[0]);
            Game.guarda.y = Integer.valueOf(vetPos[1]);
            Game.guarda.isHide = false;
        }

        if (this.atual == 0){
            Game.guarda.hide();
        }
        else if (this.atual == 1){
            Game.guarda.unhide();
        }

        if(!Game.guarda.isHide)
            Game.guarda.draw();
        Game.person.draw();
        cena.parede_ex.draw();
    }
}
