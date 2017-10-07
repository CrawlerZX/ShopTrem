package jogo;

import java.awt.*;

import jplay.*;
import jplay.Window;

public class Game {

    public static Personagem person;
    public static Guarda guarda;
    public static Window janela;
    public static Keyboard teclado;
    public static Point target;
    public static Sound conversaFX;
    public static Sound tremFX;
    public static Sound vendaFX;

    public static void main(String[] args) throws InterruptedException {

        target = new Point();

        person = new Personagem(Utilities.getImgSprite("personagem_full2.png"), 64, 1.5);

        guarda = new Guarda(Utilities.getImgSprite("guarda2.png"), 36, 1);

        janela = new Window(1280, 720);

        conversaFX = new Sound(Utilities.getFileAudio("conversa.wav"));

        tremFX = new Sound(Utilities.getFileAudio("trem.wav"));

        vendaFX = new Sound(Utilities.getFileAudio("venda.wav"));

        GameImage cenario = new GameImage(Utilities.getImgCenario("vagao.png"));
        GameImage chao = new GameImage(Utilities.getImgCenario("chao.png"));

        Parallax parallax = new Parallax();
        parallax.add(Utilities.getImgCenario("fundo_ceu.png"));
        teclado = janela.getKeyboard();

        Menu menu = new Menu();
        menu.start();
        menu.join();

        conversaFX.play();
        tremFX.play();

        teclado.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);

        while(true) {

            parallax.drawLayers();
            parallax.repeatLayers(janela.getWidth(), janela.getHeight(), true);
            parallax.setVelLayerX(0.1, parallax.getLayer(0));
            parallax.moveLayersStandardX(true);

            cenario.draw();
            chao.draw();
            person.draw();
            guarda.draw();


            if(!person.getIsThreadRun()) {
                Thread th = new Thread(person);
                th.start();
            }

            if(!guarda.isRun) {
                guarda.isRun = true;
                Thread th = new Thread(guarda);
                th.start();
            }

            if(guarda.collided(person)){
                guarda.stop();
            }

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                System.exit(1000);
            }

            if(teclado.keyDown(Keyboard.SPACE_KEY)) {
                vendaFX.play();
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
}
