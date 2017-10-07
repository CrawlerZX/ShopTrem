package jogo.Models;

public class PersonagemModel {

    private int id_sprite;
    private String nome;
    private String caminho_sprite;
    private int num_frames;
    private double velocidade;
    private String dir_som_andando;
    private String dir_som_correrendo;

    public void setId_sprite(int id_sprite) {
        this.id_sprite = id_sprite;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCaminho_sprite(String caminho_sprite) {
        this.caminho_sprite = caminho_sprite;
    }

    public void setNum_frames(int num_frames) {
        this.num_frames = num_frames;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public void setDir_som_andando(String dir_som_andando) {
        this.dir_som_andando = dir_som_andando;
    }

    public void setDir_som_correrendo(String dir_som_correrendo) {
        this.dir_som_correrendo = dir_som_correrendo;
    }

    public int getId_sprite() {
        return id_sprite;
    }

    public String getNome() {
        return nome;
    }

    public String getCaminho_sprite() {
        return caminho_sprite;
    }

    public int getNum_frames() {
        return num_frames;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public String getDir_som_andando() {
        return dir_som_andando;
    }

    public String getDir_som_correrendo() {
        return dir_som_correrendo;
    }

}
