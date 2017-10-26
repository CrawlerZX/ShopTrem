package jogo;

import jplay.Keyboard;

import javax.swing.*;

public class Personagem extends ObjectGame implements Runnable {

    private String nome;
    private float score;
    private Mochila mochila;
    private boolean isHide;
    private boolean isFree;

    public Personagem(String fileName, int numFrames, double velocidade) {
        super(fileName, numFrames, velocidade);
        this.nome = "person";
        this.score = 0;
        this.mochila = null;
        this.isHide = false;
        this.isFree = true;
        this.setSequence(0, 3);
        this.setTotalDuration(500);
        this.x = 500;
        this.y = 330;
    }

    @Override
    public void run() {
        try {
            this.setIsThreadRun(true);

            while(true) {
                if(Game.teclado.keyDown(Game.A)) {

                    if(this.x <= 0 ){

                        Thread.sleep(500);

                        Game.fase.atual = Game.fase.atual - 1;

                        this.x = Game.janela.getWidth() - this.width;

                        Thread.sleep(500);

                    }else {
                        this.x -= this.getVelocidade();
                        this.setDirection(Position.LEFT);
                    }

                    this.update();
                }
                else if(Game.teclado.keyDown(Game.D)) {

                    if(this.x >= Game.janela.getWidth() - this.width){

                        Thread.sleep(500);

                        Game.fase.atual = Game.fase.atual + 1;

                        this.x = 0;

                        Thread.sleep(500);

                    }else {
                        this.x += this.getVelocidade();
                        this.setDirection(Position.RIGHT);
                    }

                    this.update();
                }

                Game.setPositionTarget(this.x, this.y);
                Thread.currentThread().sleep(10);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.setIsThreadRun(false);
        }
    }

    public void Hide() {
        if (!this.isHide) {
            this.isHide = true;
        }
    }

    public void Sale() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setX(double x) {
        super.setX(this.x += x);
        Game.setPositionTarget(this.x, this.y);
    }

    @Override
    public void setY(double y) {
        super.setX(this.y += y);
        Game.setPositionTarget(this.x, this.y);
    }
}
