package Teste;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class GameTeste {

    public static final String SPRITE_PATH = "C:\\Arquivos\\Smaug\\Game\\src\\recursos\\sprites\\";
    public static final String CENEARIOS_PATH = "C:\\Arquivos\\Smaug\\Game\\src\\recursos\\cenarios\\";

    public static void main(String[] args){

        Window w = new Window(800, 600);

        Sprite personagem = new Sprite(GameTeste.SPRITE_PATH + "personagem_full.png", 64);
        personagem.setTotalDuration(10000);
        personagem.setInitialFrame(1);
        personagem.setFinalFrame(8);
        personagem.setLoop(true);

        GameImage fundo = new GameImage(GameTeste.CENEARIOS_PATH + "fundo.png");

        Keyboard teclado = w.getKeyboard();

        String state = "right";

        while (true) {
            fundo.draw();
            personagem.draw();

            if(teclado.keyDown(Keyboard.RIGHT_KEY)) {

                if(state != "right"){
                    personagem.setCurrFrame(0);
                    state = "right";
                }

                personagem.x += 0.2;
                personagem.setInitialFrame(1);
                personagem.setFinalFrame(8);

                personagem.update();
            }

            if(teclado.keyDown(Keyboard.LEFT_KEY)) {

                if(state != "left"){
                    personagem.setCurrFrame(32);
                    state = "left";
                }

                personagem.x -= 0.2;
                personagem.setInitialFrame(32);
                personagem.setFinalFrame(40);

                personagem.update();
            }


            if (teclado.keyDown(Keyboard.ENTER_KEY)){
                System.exit(100);
            }

            w.update();
        }

    }
}
