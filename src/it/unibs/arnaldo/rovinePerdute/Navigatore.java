package it.unibs.arnaldo.rovinePerdute;

import java.util.*;

public class Navigatore {

    //ATTRIBUTI
    private Grafo grafo;
    private Carburante carburante_prossimo_nodo;
    private Carburante carburante_al_termine;


    public ArrayList<Luogo> trovaPercorso(Luogo luogo_partenza, Luogo luogo_arrivo, Veicolo veicolo){
        //creo una Queue che sarà il mio percorso
        Queue<NodoEsteso> perorso = new PriorityQueue<>();
        //creo una Map che associa al Luogo il suo NodoEsteso, ovvero il Luogo con le info aggiuntive
        //questa map salverà tutti i luoghi visitati fin ora
        Map<Luogo, NodoEsteso> nodi_visitati = new HashMap<>();
        //creo il primo nodo con formazioni aggiuntive, sarà il nodo di luogo_partenza
        NodoEsteso nodo_partenza = new NodoEsteso(luogo_partenza, null, 0, carburante_al_termine.calcolaCarburante(luogo_partenza, luogo_arrivo, veicolo.getTipologia()));
        //lo aggiungo al percorso
        perorso.add(nodo_partenza);
        //lo aggiungo ai nodi visitati
        nodi_visitati.put(luogo_partenza, nodo_partenza);
        //ciclo fino a quando ci sono elementi
        while (!perorso.isEmpty()){

        }
        return null;
    }
}
