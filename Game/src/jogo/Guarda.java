package jogo;

import java.awt.*;

public class Guarda extends ObjectGame implements Runnable {

    private int sleepTransition;
    private int threadSleep;
    private double rayVision;
    private int dirVision;
    private Personagem target;
    private boolean targetIsTrigered;
    public boolean isRun = false;
    public boolean isHide;

    public Guarda(String fileName, int numFrames, double velocidade) {
        super(fileName, numFrames, velocidade);

        this.x = Game.config.getGuarda_init_x();
        this.y = Game.config.getGuarda_init_y();

        this.rayVision = Game.config.getGuarda_rayvision();
        this.dirVision = 1;

        this.sleepTransition = Game.config.getGame_thread_sleep_transition();
        this.threadSleep = Game.config.getGame_thread_sleep();

        this.setTotalDuration(Game.config.getGuarda_anim_duration());
        this.setSequence(0, 3);

        this.isHide = true;
    }

    @Override
    public void run() {
        this.setIsThreadRun(true);

        while (true){
            FindTarget();
            WantedTarget();
        }
    }

    public int getDirVision(){
        return dirVision;
    }

    public void setDirVision(int dirVision){

        switch (dirVision){
            case 0: this.dirVision = 0;
                break;
            case 1: this.dirVision = 1;
        }
    }

    public double getRayVision(){
        return this.rayVision;
    }

    public void setRayVision(double rayVision){
        //Validar parametro
        this.rayVision = rayVision;
    }

    public void WantedTarget() {
        try {
            while(this.targetIsTrigered && !this.isHide) {
                if(Game.getPositionTarget().x > this.x) {
                    this.x += this.getVelocidade();
                    this.setDirection(Position.RIGHT);
                }
                else if (Game.getPositionTarget().x < this.x) {
                    this.x -= this.getVelocidade();
                    this.setDirection(Position.LEFT);
                }
                else if (Game.getPositionTarget().x == this.x){
                    if (Game.getPositionTarget().y == this.y){
                        System.exit(100);
                    }
                }
//                if(Game.getPositionTarget().y > this.y) {
//                    this.y += this.getVelocidade();
//                }
//                else if (Game.getPositionTarget().y < this.y) {
//                    this.y -= this.getVelocidade();
//                }

                this.update();
                FindTarget();
                Thread.currentThread().sleep(this.threadSleep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FindTarget() {

        Point personLocation = Game.getPositionTarget();
        double distancia = personLocation.distance(this.x, this.y);

        System.out.println("Guarda: " + this.x + " " + this.y);
        System.out.println("Personagem: " + personLocation.x + " " + personLocation.y);

        //Olhando para a esquerda
        if (this.dirVision == 0){
            if(personLocation.x < this.x){
                if (distancia <= this.rayVision){
                    this.targetIsTrigered = true;
                }
                else {
                    this.targetIsTrigered = false;
                }
            }
        }
        else if (this.dirVision == 1){
            if (personLocation.x > this.x){
                if (distancia <= rayVision){
                    this.targetIsTrigered = true;
                }
                else {
                    this.targetIsTrigered = false;
                }
            }
        }
    }
}
