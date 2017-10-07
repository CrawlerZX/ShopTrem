package jogo;

import jplay.Keyboard;

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
        this.setSequence(0, 7);
        this.setTotalDuration(5000);
        this.x = 50;
        this.y = 450;
    }

    @Override
    public void run() {
        try {
            this.setIsThreadRun(true);

            while(true) {
                if(Game.teclado.keyDown(Keyboard.LEFT_KEY)) {
                    this.x -= this.getVelocidade();
                    if(Game.teclado.keyDown(Keyboard.UP_KEY)) {
                        this.y -= this.getVelocidade();
                        this.setDirection(Position.LEFT_UP);
                    }
                    else if(Game.teclado.keyDown(Keyboard.DOWN_KEY)) {
                        this.y += this.getVelocidade();
                        this.setDirection(Position.LEFT_DOWN);
                    }
                    else {
                        this.setDirection(Position.LEFT);
                    }
                    this.update();
                }
                else if(Game.teclado.keyDown(Keyboard.RIGHT_KEY)) {
                    this.x += this.getVelocidade();
                    if(Game.teclado.keyDown(Keyboard.UP_KEY)) {
                        this.y -= this.getVelocidade();
                        this.setDirection(Position.RIGHT_UP);
                    }
                    else if(Game.teclado.keyDown(Keyboard.DOWN_KEY)) {
                        this.y += this.getVelocidade();
                        this.setDirection(Position.RIGHT_DOWN);
                    }
                    else {
                        this.setDirection(Position.RIGHT);
                    }
                    this.update();
                }
                else if(Game.teclado.keyDown(Keyboard.UP_KEY)) {
                    this.y -= this.getVelocidade();
                    this.setDirection(Position.UP);
                    this.update();
                }
                else if (Game.teclado.keyDown(Keyboard.DOWN_KEY)) {
                    this.y += this.getVelocidade();
                    this.setDirection(Position.DOWN);
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
