package com.example.quiz;

public class Reponse {

    private int id_R;
    private String contenu;
    private boolean check;
    private int id_Q;

    public int getId_R() {
        return id_R;
    }

    public void setId_R(int id_R) {
        this.id_R = id_R;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getId_Q() {
        return id_Q;
    }

    public void setId_Q(int id_Q) {
        this.id_Q = id_Q;
    }
}
