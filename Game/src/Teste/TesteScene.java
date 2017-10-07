package Teste;

import jogo.Game;
import jogo.Utilities;
import jplay.GameImage;
import jplay.Parallax;
import jplay.Scene;
import jplay.Window;

public class TesteScene {

    private Window window;
    private Scene scene;

    public TesteScene()
    {
        window = new Window(1280,720);
        scene = new Scene();
        scene.loadFromFile(Utilities.getImgCenario("cenario.scn"));
        scene.setDrawStartPos(0, 0);

    }

    public void run()
    {
        Parallax parallax = new Parallax();
        parallax.add(Utilities.getImgTile("parallax.png"));

        GameImage parede = new GameImage(Utilities.getImgTile("parede_interna.png"));
        parede.y = 180;


        while(true)
        {
            scene.draw();

            parallax.drawLayers();
            parallax.repeatLayers(window.getWidth(), window.getHeight(), true);
            parallax.setVelLayerX(3, parallax.getLayer(0));
            parallax.moveLayersStandardX(true);

            parede.draw();


            window.update();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TesteScene cen = new TesteScene();
        cen.run();
    }

}
