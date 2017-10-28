package jogo.DAO;

import jplay.Sprite;

public class CenarioModel {

    private int     id_cenario;
    private int     id_fase;
    private String  dir_trem;
    private String  dir_parede;
    private int     nm_guarda;
    private int     nm_cliente;
    private String pos_guarda1;
    private String pos_guarda2;
    private String pos_guarda3;
    private String pos_guarda4;
    private String pos_guarda5;
    private String pos_guarda6;
    private String pos_guarda7;
    private String pos_guarda8;
    private String pos_guarda9;
    private String pos_guarda10;
    private String pos_cliente1;
    private String pos_cliente2;
    private String pos_cliente3;
    private String pos_cliente4;
    private String pos_cliente5;
    private String pos_cliente6;

    public Sprite trem;
    public Sprite parede_ex;

    public CenarioModel() {
    }

    public int getId_cenario() {
        return id_cenario;
    }

    public int getId_fase() {
        return id_fase;
    }

    public String getDir_trem() {
        return dir_trem;
    }

    public String getDir_parede() {
        return dir_parede;
    }

    public int getNm_guarda() {
        return nm_guarda;
    }

    public int getNm_cliente() {
        return nm_cliente;
    }

    public String getPos_guarda1() {
        return pos_guarda1;
    }

    public String getPos_guarda2() {
        return pos_guarda2;
    }

    public String getPos_guarda3() {
        return pos_guarda3;
    }

    public String getPos_guarda4() {
        return pos_guarda4;
    }

    public String getPos_guarda5() {
        return pos_guarda5;
    }

    public String getPos_guarda6() {
        return pos_guarda6;
    }

    public String getPos_guarda7() {
        return pos_guarda7;
    }

    public String getPos_guarda8() {
        return pos_guarda8;
    }

    public String getPos_guarda9() {
        return pos_guarda9;
    }

    public String getPos_guarda10() {
        return pos_guarda10;
    }

    public String getPos_cliente1() {
        return pos_cliente1;
    }

    public String getPos_cliente2() {
        return pos_cliente2;
    }

    public String getPos_cliente3() {
        return pos_cliente3;
    }

    public String getPos_cliente4() {
        return pos_cliente4;
    }

    public String getPos_cliente5() {
        return pos_cliente5;
    }

    public String getPos_cliente6() {
        return pos_cliente6;
    }

    public void setId_cenario(int id_cenario) {
        this.id_cenario = id_cenario;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public void setDir_trem(String dir_trem) {
        this.dir_trem = dir_trem;
        this.trem = new Sprite(dir_trem);
    }

    public void setDir_parede(String dir_parede) {
        this.dir_parede = dir_parede;
        this.parede_ex = new Sprite(dir_parede);
    }

    public void setNm_guarda(int nm_guarda) {
        this.nm_guarda = nm_guarda;
    }

    public void setNm_cliente(int nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public void setPos_guarda1(String pos_guarda1) {
        this.pos_guarda1 = pos_guarda1;
    }

    public void setPos_guarda2(String pos_guarda2) {
        this.pos_guarda2 = pos_guarda2;
    }

    public void setPos_guarda3(String pos_guarda3) {
        this.pos_guarda3 = pos_guarda3;
    }

    public void setPos_guarda4(String pos_guarda4) {
        this.pos_guarda4 = pos_guarda4;
    }

    public void setPos_guarda5(String pos_guarda5) {
        this.pos_guarda5 = pos_guarda5;
    }

    public void setPos_guarda6(String pos_guarda6) {
        this.pos_guarda6 = pos_guarda6;
    }

    public void setPos_guarda7(String pos_guarda7) {
        this.pos_guarda7 = pos_guarda7;
    }

    public void setPos_guarda8(String pos_guarda8) {
        this.pos_guarda8 = pos_guarda8;
    }

    public void setPos_guarda9(String pos_guarda9) {
        this.pos_guarda9 = pos_guarda9;
    }

    public void setPos_guarda10(String pos_guarda10) {
        this.pos_guarda10 = pos_guarda10;
    }

    public void setPos_cliente1(String pos_cliente1) {
        this.pos_cliente1 = pos_cliente1;
    }

    public void setPos_cliente2(String pos_cliente2) {
        this.pos_cliente2 = pos_cliente2;
    }

    public void setPos_cliente3(String pos_cliente3) {
        this.pos_cliente3 = pos_cliente3;
    }

    public void setPos_cliente4(String pos_cliente4) {
        this.pos_cliente4 = pos_cliente4;
    }

    public void setPos_cliente5(String pos_cliente5) {
        this.pos_cliente5 = pos_cliente5;
    }

    public void setPos_cliente6(String pos_cliente6) {
        this.pos_cliente6 = pos_cliente6;
    }

}
