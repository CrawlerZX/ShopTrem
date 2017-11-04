package jogo;

import jplay.Sprite;

public abstract class ObjectGame extends Sprite implements Runnable {

    private boolean isThreadRun;
    private double velocidade;
    private int direction;

    public ObjectGame(String fileName) {
        this(fileName, 0, 1);
    }

    public ObjectGame(String fileName, int numFrames, double velocidade) {
        super(fileName, numFrames);
        this.isThreadRun = false;
        this.velocidade = velocidade;
        this.direction = Position.RIGHT;
    }

    protected boolean getIsThreadRun(){
        return this.isThreadRun;
    }

    protected void setIsThreadRun(boolean run) { this.isThreadRun = run; }

    protected double getVelocidade(){
        return this.velocidade;
    }

    protected void setVelocidade(double vel) { this.velocidade = vel; }

    protected void setDirection(int pos){
        if(this.direction != pos){
            this.direction = pos;
            this.setSequence(pos, pos + 4);
        }
    }
}
