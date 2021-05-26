package it.unibs.arnaldo.rovinePerdute;

import java.util.ArrayList;

public class Veicolo implements Carburante{
    //ATTRIBUTI
    private int fuel;
    private ArrayList<Integer> route;
    private String tipologia;

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public ArrayList<Integer> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Integer> route) {
        this.route = route;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public int calcolaCarburante(Luogo luogo_partenza, Luogo luogo_arrivo, String tipologia) {
        switch (tipologia){
            case Costanti.METZTLI:
                break;
            case Costanti.TONATHIU:
                break;
        }
        return 0;
    }
}
