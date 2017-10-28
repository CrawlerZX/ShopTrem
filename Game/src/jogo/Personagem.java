package jogo;

import jplay.Keyboard;

import javax.swing.*;

public class Personagem extends ObjectGame implements Runnable {

    private String nome;
    private float score;
    private Mochila mochila;
    private boolean isHide;
    private boolean isFree;

    private int sleep;
    private int thsleep;

    public Personagem(String fileName, int numFrames, double velocidade) {
        super(fileName, numFrames, velocidade);

        this.nome = "person";
        this.score = 0;
        this.mochila = null;
        this.isHide = false;
        this.isFree = true;
        this.setSequence(0, 3);

        this.setTotalDuration(Game.config.getPerson_anim_duration());

        this.x = Game.config.getPerson_init_x();
        this.y = Game.config.getPerson_init_y();

        this.sleep = Game.config.getGame_thread_sleep_transition();
        this.thsleep = Game.config.getGame_thread_sleep();
    }

    @Override
    public void run() {
        try {
            this.setIsThreadRun(true);

            while(true) {
                if(Game.teclado.keyDown(Game.A)) {

                    if(this.x <= 0 && Game.fase.atual > 0){

                        Thread.sleep(this.sleep);

                        Game.fase.atual = Game.fase.atual - 1;

                        this.x = Game.janela.getWidth() - this.width;

                        Thread.sleep(this.sleep);

                    }else if(Game.fase.atual == 0) {
                        if (this.x >= 500){
                            this.x -= this.getVelocidade();
                            this.setDirection(Position.LEFT);
                        }
                    }
                    else {
                        this.x -= this.getVelocidade();
                        this.setDirection(Position.LEFT);
                    }

                    this.update();
                }
                else if(Game.teclado.keyDown(Game.D)) {

                    if(this.x >= Game.janela.getWidth() - this.width && Game.fase.atual < 5){

                        Thread.sleep(this.sleep);

                        Game.fase.atual = Game.fase.atual + 1;

                        this.x = 0;

                        Thread.sleep(this.sleep);

                    }else if(Game.fase.atual == 4) {
                        if (this.x <= 690){
                            this.x += this.getVelocidade();
                            this.setDirection(Position.RIGHT);
                        }
                    }else {
                        this.x += this.getVelocidade();
                        this.setDirection(Position.RIGHT);
                    }

                    this.update();
                }


                int cima = 320;
                int meio = 330;
                int baixo = 320;

                if(Game.teclado.keyDown(Game.W)){
                    if (this.y >= meio){
                        this.y -= 10;
                    }
                }
                else if(Game.teclado.keyDown(Game.S)){
                    if(this.y <= cima){
                        this.y += 10;
                    }
                }

                Game.setPositionTarget(this.x, this.y);
                Thread.currentThread().sleep(this.thsleep);
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
