package Teste;

import jogo.Utilities;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class TesteAnim {

    public static void main(String[] args){

        Window janela = new Window(800, 600);
        Keyboard teclado = janela.getKeyboard();

        Sprite anim = new Sprite(Utilities.getImgSprite("teste\\marreta_esconde_costas.png"), 3);
        anim.setTotalDuration(1000);
        anim.setLoop(true);

        GameImage bg = new GameImage(Utilities.getImgSprite("teste\\bg.png"));

        while (true) {

            bg.draw();
            anim.draw();

            if(teclado.keyDown(Keyboard.UP_KEY)){

                while (anim.isPlaying()){
                    anim.draw();
                    anim.update();
                }
            }

            if (teclado.keyDown(Keyboard.ENTER_KEY)){

                System.exit(1000);
            }

            janela.update();
        }
    }
}
