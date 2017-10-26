package jogo;

import java.awt.*;
import java.util.ArrayList;

import jplay.*;
import jplay.Window;

public class Game {

    public static Personagem person;
    public static Guarda guarda;
    public static Window janela;
    public static Keyboard teclado;
    public static Point target;
    public static Sound som;

    public static Fase fase;

    public static final int A = 65;
    public static final int D = 68;

    public static void main(String[] args) throws InterruptedException {

        target = new Point();

        person = new Personagem(Utilities.getImgSprite("sprite_sheet_person.png"), 8, 3.5);

        guarda = new Guarda(Utilities.getImgSprite("sprite_sheet_person.png"), 64, 1);

        janela = new Window(1280, 720);

        Parallax parallax = new Parallax();
        parallax.add(Utilities.getImgCenario("fase1\\fundo.png"));
        parallax.add(Utilities.getImgCenario("fase1\\trilho.png"));

        carregaFase();

        teclado = janela.getKeyboard();
        teclado.addKey(Game.A);
        teclado.addKey(Game.D);

        Sound musica = new Sound(Utilities.getFileAudio("menu_fundo.wav"));
        musica.setRepeat(true);
        musica.play();

        Menu menu = new Menu();
        menu.start();
        menu.join();

        musica.stop();

        som = new Sound(Utilities.getFileAudio("fundo.wav"));
        som.setRepeat(true);
        som.play();

        teclado.setBehavior(Game.A,   Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Game.D,   Keyboard.DETECT_EVERY_PRESS);

        teclado.setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);

        while(true) {

            parallax.drawLayers();
            parallax.repeatLayers(janela.getWidth(), janela.getHeight(), true);
            parallax.setVelLayerX(8, parallax.getLayer(0));
            parallax.setVelLayerX(8, parallax.getLayer(1));
            parallax.moveLayersStandardX(true);

            fase.draw();

            if(!person.getIsThreadRun()) {
                Thread th = new Thread(person);
                th.start();
            }

            if(!guarda.getIsThreadRun()) {
                Thread th = new Thread(guarda);
                th.start();
            }

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                System.exit(1000);
            }

            janela.update();
        }
    }


    public static void setPositionTarget(double posicaoXDoPersonagem, double posicaoYDoPersonagem){
        Game.target.setLocation(posicaoXDoPersonagem, posicaoYDoPersonagem);
    }

    public static Point getPositionTarget(){
        return Game.target;
    }

    public static void carregaFase(){

        ArrayList<Cenario> listCenarios = new ArrayList<>();

//        Sprite motor1 = new Sprite(Utilities.getImgCenario("Fase 1\\Motor 1.png"));

//        Sprite trilho1 = new Sprite(Utilities.getImgCenario("Fase 1\\Trilho 1.png"));

//        Sprite chao1 = new Sprite(Utilities.getImgCenario("Fase 1\\Chao 1.png"));

        Sprite trem6 = new Sprite(Utilities.getImgCenario("fase1\\trem1.png"));

        Sprite parede_ex1 = new Sprite(Utilities.getImgCenario("fase1\\frente1.png"));

        Cenario cenario = new Cenario(trem6, parede_ex1);
        listCenarios.add(cenario);

//        Sprite motor2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Motor 2.png"));
//
//        Sprite trilho2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Trilho 2.png"));
//
//        Sprite chao2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Chao 2.png"));

        Sprite trem2 = new Sprite(Utilities.getImgCenario("fase1\\trem2.png"));

        Sprite parede_ex2 = new Sprite(Utilities.getImgCenario("fase1\\frente2.png"));

        Cenario cenario2 = new Cenario(trem2, parede_ex2);
        listCenarios.add(cenario2);

//        Sprite motor3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Motor 3.png"));
//
//        Sprite trilho3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Trilho 3.png"));
//
//        Sprite chao3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Chao 3.png"));

        Sprite trem3 = new Sprite(Utilities.getImgCenario("fase1\\trem3.png"));

        Sprite parede_ex3 = new Sprite(Utilities.getImgCenario("fase1\\frente3.png"));

        Cenario cenario3 = new Cenario(trem3, parede_ex3);
        listCenarios.add(cenario3);

//        Sprite motor4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Motor 4.png"));
//
//        Sprite trilho4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Trilho 4.png"));
//
//        Sprite chao4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Chao 4.png"));

        Sprite trem4 = new Sprite(Utilities.getImgCenario("fase1\\trem4.png"));

        Sprite parede_ex4 = new Sprite(Utilities.getImgCenario("fase1\\frente4.png"));

        Cenario cenario4 = new Cenario(trem4, parede_ex4);
        listCenarios.add(cenario4);

//        Sprite motor5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Motor 5.png"));
//
//        Sprite trilho5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Trilho 5.png"));
//
//        Sprite chao5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Chao 5.png"));

        Sprite trem5 = new Sprite(Utilities.getImgCenario("fase1\\trem5.png"));

        Sprite parede_ex5 = new Sprite(Utilities.getImgCenario("fase1\\frente5.png"));

        Cenario cenario5 = new Cenario(trem5, parede_ex5);
        listCenarios.add(cenario5);

        fase = new Fase(listCenarios);
    }
}
