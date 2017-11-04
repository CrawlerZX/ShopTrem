package Teste;

import jogo.Utilities;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class TesteSprite {

    public static void main(String[] args){

        String bgPath = Utilities.getImgSprite("teste\\bg.png");

        Sprite obj1 = new Sprite(Utilities.getImgSprite("teste\\teste.png"), 12);
        obj1.setSequence(0, 5);
        obj1.setTotalDuration(1000);

        Sprite obj2 = new Sprite(Utilities.getImgSprite("teste\\teste.png"), 12);
        obj2.setSequence(5, 10);
        obj2.setTotalDuration(1000);
        obj2.setY(200);

        Window janela = new Window(800, 600);
        Keyboard teclado = janela.getKeyboard();

        Sprite bg = new Sprite(bgPath);

        while (true){

            bg.draw();

            obj1.update();
            obj1.draw();

            obj2.update();
            obj2.draw();

            if (teclado.keyDown(Keyboard.ENTER_KEY)){
                System.exit(1000);
            }

            janela.update();
        }
    }
}
