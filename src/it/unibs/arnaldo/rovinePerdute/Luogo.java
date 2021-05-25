package it.unibs.arnaldo.rovinePerdute;

import java.util.ArrayList;
import java.util.Objects;

public class Luogo {

    //attributi
    private int id;
    private String nome;
    private Posizione posizione;

    //costruttore
    public Luogo(int id, String nome, Posizione posizione) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
    }

    //metodo cortruttore di un luogo con gli attributi settati ai valori di default
    public  Luogo() { }

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

}
