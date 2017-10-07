package Teste;

import jplay.Keyboard;
import jplay.Parallax;
import jplay.Window;

public class Paralax {

    public static void main(String[] args){

        Window j = new Window(800, 600);

        Parallax p = new Parallax();
        p.add(GameTeste.CENEARIOS_PATH + "fundo_cenario.png");

        Keyboard teclado = j.getKeyboard();

        while (true){

            p.drawLayers();
            p.setVelLayerX(1, p.getLayer(0));
            p.repeatLayers(800, 600, true);
            p.moveLayersStandardX(true);



            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                System.exit(100);
            }

            j.update();
        }
    }
}
