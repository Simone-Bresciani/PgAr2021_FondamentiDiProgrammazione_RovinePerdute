package it.unibs.arnaldo.rovinePerdute;

import java.util.ArrayList;

public class Luogo {

    //attributi
    private int id;
    private String nome;
    private Posizione posizione;
    private ArrayList<Integer> connessioni;

    //costruttore
    public Luogo(int id, String nome, Posizione posizione, ArrayList<Integer> connessioni) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.connessioni = connessioni;
    }

    //get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public ArrayList<Integer> getConnessioni() {
        return connessioni;
    }

    public void setConnessioni(ArrayList<Integer> connessioni) {
        this.connessioni = connessioni;
    }
}
