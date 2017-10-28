package Teste;

import jogo.Utilities;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class TesteIntro {

    public static void main(String[] args){

        Window janela = new Window(1280, 720);

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

            janela.update();

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                System.exit(1000);
            }
        }
    }
}
