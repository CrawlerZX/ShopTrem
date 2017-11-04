package jogo;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import jogo.DAO.ConfigDAL;
import jogo.DAO.ConfigModel;
import jogo.DAO.FaseDAL;
import jogo.DAO.FaseModel;
import jplay.*;
import jplay.Window;

public class Game {

    public static ConfigModel config;

    public static Personagem person;
    public static Guarda guarda;
    public static Parallax parallax;

    public static Sound musicaMenu;
    public static Menu menu;

    public static Sprite cliente;
    public static Window janela;
    public static Keyboard teclado;
    public static Point target;
    public static Sound somFase;

    public static Fase fase;

    public static final int A = 65;
    public static final int D = 68;
    public static final int W = 87;
    public static final int S = 83;

    public static void main(String[] args) throws Exception {

        config = ConfigDAL.getConfig();
        ApplyConfig();
        carregaFase();

//        Intro intro = new Intro(janela);
//        intro.start();
//        intro.join();

//        musicaMenu.play();
        menu.start();
        menu.join();
//        musicaMenu.stop();

//        somFase.play();
        Parallax tst = new Parallax();
        tst.add(Utilities.getImgCenario("fase1\\poste.png"));

        Sprite numeros = new Sprite(Utilities.getImgSprite("numeros\\numeros.png"), 9);
        numeros.setLoop(false);
        numeros.setCurrFrame(0);

        while(true) {

            parallax.drawLayers();
            parallax.repeatLayers(janela.getWidth(), janela.getHeight(), true);
            parallax.setVelLayerX(10, parallax.getLayer(0));
            parallax.setVelLayerX(10, parallax.getLayer(1));
            parallax.moveLayersStandardX(true);

            cliente.update();
            fase.draw();
            numeros.draw();

            tst.drawLayers();
            tst.repeatLayers(janela.getWidth(), janela.getHeight(), true);
            tst.setVelLayerX(8, tst.getLayer(0));
            tst.moveLayersStandardX(true);

            if(!person.getIsThreadRun()) {
                Thread th = new Thread(person);
                th.start();
            }

            if(!guarda.getIsThreadRun()){
                Thread th = new Thread(guarda);
                th.start();
            }

            if (person.collided(Game.cliente)){
                numeros.setCurrFrame(1);
            }

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                System.exit(1000);
            }

            janela.update();
        }
    }

    private static void ApplyConfig() {

        Game.person = new Personagem(config.getPerson_dir_img(), config.getPerson_num_frame(), config.getPerson_vel());
//        Game.person = new Personagem(Utilities.getImgSprite("teste\\guarda_andando2.png"), 8, 3.5);
        Game.guarda = new Guarda(config.getGuarda_dir_img(), config.getGuarda_num_frame(), config.getGuarda_vel());

        Game.janela = new Window(config.getGame_janela_w(), config.getGame_janela_h());

        cliente = new Sprite(Utilities.getImgSprite("cliente.png"), 2);
        cliente.setTotalDuration(5000);
        cliente.setLoop(true);
        cliente.setX(1190);
        cliente.setY(320);

        parallax = new Parallax();
        parallax.add(Utilities.getImgCenario("fase1\\fundo.png"));
        parallax.add(Utilities.getImgCenario("fase1\\trilho.png"));

        teclado = janela.getKeyboard();
        teclado.addKey(Game.A);
        teclado.addKey(Game.D);
        teclado.addKey(Game.W);
        teclado.addKey(Game.S);

        musicaMenu = new Sound(Utilities.getFileAudio("menu_fundo.wav"));
        musicaMenu.setRepeat(true);

        menu = new Menu();

        somFase = new Sound(Utilities.getFileAudio("fundo.wav"));
        somFase.setRepeat(true);

        teclado.setBehavior(Game.A,   Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Game.D,   Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Game.W,   Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Game.S,   Keyboard.DETECT_INITIAL_PRESS_ONLY);

        teclado.setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);

        target = new Point();
    }

    public static void setPositionTarget(double posicaoXDoPersonagem, double posicaoYDoPersonagem){
        Game.target.setLocation(posicaoXDoPersonagem, posicaoYDoPersonagem);
    }

    public static Point getPositionTarget(){
        return Game.target;
    }

    public static void carregaFase() throws SQLException {

//        ArrayList<Cenario> listCenarios = new ArrayList<>();
//
////        Sprite motor1 = new Sprite(Utilities.getImgCenario("Fase 1\\Motor 1.png"));
//
////        Sprite trilho1 = new Sprite(Utilities.getImgCenario("Fase 1\\Trilho 1.png"));
//
////        Sprite chao1 = new Sprite(Utilities.getImgCenario("Fase 1\\Chao 1.png"));
//
//        Sprite trem6 = new Sprite(Utilities.getImgCenario("fase1\\trem1.png"));
//
//        Sprite parede_ex1 = new Sprite(Utilities.getImgCenario("fase1\\frente1.png"));
//
//        Cenario cenario = new Cenario(trem6, parede_ex1);
//        listCenarios.add(cenario);
//
////        Sprite motor2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Motor 2.png"));
////
////        Sprite trilho2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Trilho 2.png"));
////
////        Sprite chao2 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 2\\Chao 2.png"));
//
//        Sprite trem2 = new Sprite(Utilities.getImgCenario("fase1\\trem2.png"));
//
//        Sprite parede_ex2 = new Sprite(Utilities.getImgCenario("fase1\\frente2.png"));
//
//        Cenario cenario2 = new Cenario(trem2, parede_ex2);
//        listCenarios.add(cenario2);
//
////        Sprite motor3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Motor 3.png"));
////
////        Sprite trilho3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Trilho 3.png"));
////
////        Sprite chao3 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 3\\Chao 3.png"));
//
//        Sprite trem3 = new Sprite(Utilities.getImgCenario("fase1\\trem3.png"));
//
//        Sprite parede_ex3 = new Sprite(Utilities.getImgCenario("fase1\\frente3.png"));
//
//        Cenario cenario3 = new Cenario(trem3, parede_ex3);
//        listCenarios.add(cenario3);
//
////        Sprite motor4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Motor 4.png"));
////
////        Sprite trilho4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Trilho 4.png"));
////
////        Sprite chao4 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 4\\Chao 4.png"));
//
//        Sprite trem4 = new Sprite(Utilities.getImgCenario("fase1\\trem4.png"));
//
//        Sprite parede_ex4 = new Sprite(Utilities.getImgCenario("fase1\\frente4.png"));
//
//        Cenario cenario4 = new Cenario(trem4, parede_ex4);
//        listCenarios.add(cenario4);
//
////        Sprite motor5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Motor 5.png"));
////
////        Sprite trilho5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Trilho 5.png"));
////
////        Sprite chao5 = new Sprite(Utilities.getImgCenario("Fase 1\\Fase 5\\Chao 5.png"));
//
//        Sprite trem5 = new Sprite(Utilities.getImgCenario("fase1\\trem5.png"));
//
//        Sprite parede_ex5 = new Sprite(Utilities.getImgCenario("fase1\\frente5.png"));
//
//        Cenario cenario5 = new Cenario(trem5, parede_ex5);
//        listCenarios.add(cenario5);

        FaseModel obj = FaseDAL.getFase();
        fase = new Fase(obj.getNome(), obj.listCenario);
    }
}
