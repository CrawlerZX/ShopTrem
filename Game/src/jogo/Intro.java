package jogo;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Intro extends Thread {

    Window janela;

    public Intro(Window janela){
        this.janela = janela;
    }

    public void run(){

        try {
            Sprite bg = new Sprite(Utilities.getImgCenario("background.png"));
            Sprite intro = new Sprite(Utilities.getImgCenario("intro.png"), 273);
            intro.x = 300;
            intro.y = 150;
            intro.setTotalDuration(5000);
            intro.setLoop(false);

            Keyboard teclado = janela.getKeyboard();

            bg.draw();

            while (true){

                intro.draw();
                intro.update();

                if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
                    intro.setCurrFrame(intro.getCurrFrame() + 1);
                }

                if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                    System.exit(1000);
                }

                janela.update();

                if(intro.getCurrFrame() == 272){
                    Thread.sleep(1000);
                    return;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
