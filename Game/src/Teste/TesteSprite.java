package Teste;

import jogo.Utilities;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class TesteSprite {

    public static void main(String[] args){

        long duration = 2000;
        String imgPath1 = Utilities.getImgSprite("teste\\guarda_andando.png");
        int numFrames1 = 4;
        String bgPath = Utilities.getImgSprite("teste\\bg.png");

        String imgPath2 = Utilities.getImgSprite("teste\\guarda_correndo.png");
        int numFrames2 = 4;

        String imgPath3 = Utilities.getImgSprite("teste\\guarda_entra.png");
        int numFrames3 = 8;

        String imgPath4 = Utilities.getImgSprite("teste\\marreta_esconde_costas.png");
        int numFrames4 = 3;

        Sprite obj1 = new Sprite(imgPath1, numFrames1);
        obj1.setTotalDuration(duration);

        Sprite obj2 = new Sprite(imgPath2, numFrames2);
        obj2.setTotalDuration(duration);
        obj2.setY(100);

        Sprite obj3 = new Sprite(imgPath3, numFrames3);
        obj3.setTotalDuration(duration);
        obj3.setY(200);

        Sprite obj4 = new Sprite(imgPath4, numFrames4);
        obj4.setTotalDuration(1000);
        obj4.setY(300);

        Window janela = new Window(800, 600);
        Keyboard teclado = janela.getKeyboard();

        Sprite bg = new Sprite(bgPath);

        while (true){

            bg.draw();

            obj1.update();
            obj1.draw();

            obj2.update();
            obj2.draw();

            obj3.update();
            obj3.draw();

            obj4.update();
            obj4.draw();

            if (teclado.keyDown(Keyboard.ENTER_KEY)){
                System.exit(1000);
            }

            janela.update();
        }
    }
}
