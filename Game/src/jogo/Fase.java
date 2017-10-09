package jogo;

import java.util.ArrayList;

public class Fase {

    private ArrayList<Cenario> cenarios;
    public int atual;

    public Fase( ArrayList<Cenario> cenarios){

        this.cenarios = cenarios;
        this.atual = 0;
    }

    public void draw() {

        Cenario cena = cenarios.get(atual);

        cena.trilho.draw();
        cena.motor.draw();
        cena.chao.draw();
        cena.parede_in.draw();
        Game.person.draw();
        cena.parede_ex.draw();
    }
}