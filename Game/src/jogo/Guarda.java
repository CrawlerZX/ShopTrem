package jogo;

import java.awt.*;

public class Guarda extends ObjectGame implements Runnable {

    private double rayVision;
    private int dirVision;
    private Personagem target;
    private boolean targetIsTrigered;
    public boolean isRun = false;

    public Guarda(String fileName, int numFrames, double velocidade) {
        super(fileName, numFrames, velocidade);
        this.x = 250;
        this.y = 450;
        this.rayVision = 200;
        this.dirVision = 1;
    }

    @Override
    public void run() {

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
            while(this.targetIsTrigered) {
                if(Game.getPositionTarget().x > this.x) {
                    this.x += this.getVelocidade();
                }
                else if (Game.getPositionTarget().x < this.x) {
                    this.x -= this.getVelocidade();
                }

                if(Game.getPositionTarget().y > this.y) {
                    this.y += this.getVelocidade();
                }
                else if (Game.getPositionTarget().y < this.y) {
                    this.y -= this.getVelocidade();
                }

                FindTarget();
                Thread.currentThread().sleep(10);
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
