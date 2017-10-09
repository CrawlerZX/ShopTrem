package jogo;

import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;

import javax.swing.*;

public class Menu extends Thread {

    Sprite backGround;
    Keyboard keyboard;
    int opcaoEscolhida = 0;
//    Sound efeito;
    static ImageIcon img;

    public Menu(){

        backGround = new Sprite(Utilities.getImgCenario("menu.png"), 4);
        keyboard = Game.janela.getKeyboard();

//        efeito = new Sound(Utilities.getFileAudio("menu_efeito.wav"));

        keyboard.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_INITIAL_PRESS_ONLY);
        keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
    }

    public void run(){


        this.printar();

    }

    private void verificaOpcao(){

        Sound efeito = new Sound(Utilities.getFileAudio("menu_efeito.wav"));
        efeito.setVolume(0.0001f);

        if(keyboard.keyDown(Keyboard.UP_KEY)){
            if(opcaoEscolhida == 0){
                this.opcaoEscolhida = 3;
            }
            else {
                this.opcaoEscolhida--;
            }

            efeito.play();

        }
        else if (keyboard.keyDown(Keyboard.DOWN_KEY)) {

            if(opcaoEscolhida == 3){
                opcaoEscolhida = 0;
            }
            else {
                opcaoEscolhida++;
            }

            efeito.play();
        }

        efeito = null;
    }

    private void desenhar()
    {
        this.backGround.setCurrFrame(opcaoEscolhida);
        backGround.draw();
        Game.janela.update();
    }

    public void printar(){

        while (true){
            desenhar();
            verificaOpcao();

            if(keyboard.keyDown(Keyboard.ENTER_KEY)) {
                return;
            }
        }
    }
}
