package it.unibs.arnaldo.rovinePerdute;

import java.util.ArrayList;

public class Veicolo{
    //ATTRIBUTI
    private int fuel;
    private ArrayList<Integer> route;
    private String tipologia;

    public Veicolo(int fuel, ArrayList<Integer> route, String tipologia) {
        this.fuel = fuel;
        this.route = route;
        this.tipologia = tipologia;
    }

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

}
