package it.unibs.arnaldo.rovinePerdute;

import java.util.ArrayList;

public class Veicolo{
    //ATTRIBUTI
    private double fuel;
    private ArrayList<Integer> route;
    private String tipologia;

    public Veicolo(ArrayList<Integer> route, String tipologia) {
        this.fuel = 0d;
        this.route = route;
        this.tipologia = tipologia;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
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
