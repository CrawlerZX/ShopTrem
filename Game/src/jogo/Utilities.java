package jogo;

import java.io.File;

public class Utilities {

    public static String getImgSprite(String fileName){

        String path = System.getProperty("user.dir") + "\\src\\recursos\\sprites\\" + fileName;

        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        return path;
    }

    public static String getImgCenario(String fileName){

        String path = System.getProperty("user.dir") + "\\src\\recursos\\cenarios\\" + fileName;

        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        return path;
    }

    public static String getFileAudio(String fileName){

        String path = System.getProperty("user.dir") + "\\src\\recursos\\audio\\" + fileName;

        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        return path;
    }

    public static String getImgTile(String fileName) {

        String path = System.getProperty("user.dir") + "\\src\\recursos\\tiles\\" + fileName;

        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        return path;

    }

    public static String getConfigPath() {

        String path = System.getProperty("user.dir") + "\\src\\jogo\\config\\game.config.txt";

        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        return path;

    }

}
