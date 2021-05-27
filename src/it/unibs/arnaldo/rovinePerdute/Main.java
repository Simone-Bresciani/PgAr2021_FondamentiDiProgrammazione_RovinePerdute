package it.unibs.arnaldo.rovinePerdute;
import it.unibs.arnaldo.rovinePerdute.ServiziFileXML.LetturaFileXML;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //genera grafo
        Grafo grafo = LetturaFileXML.leggiMappa(Costanti.FILE_10000_CITTA);
        //genera luoghi
        Luogo partenza = grafo.getNodi(0);
        Luogo arrivo = grafo.getNodi(9999);
        //genera navigatore
        Navigatore navigatore = new Navigatore(grafo);
        //genera veicolo
        Veicolo veicolo1 = new Veicolo(100000000, null, Costanti.METZTLI);
        //comunica percorso
        ArrayList<Luogo> percorso = navigatore.trovaPercorso(partenza, arrivo, veicolo1);

        System.out.println("");
    }
}
