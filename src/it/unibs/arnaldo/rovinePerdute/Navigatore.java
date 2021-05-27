package it.unibs.arnaldo.rovinePerdute;

import java.util.*;

public class Navigatore {

    //ATTRIBUTI
    private final Grafo grafo;

    public Navigatore(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Luogo> trovaPercorso(Luogo luogo_partenza, Luogo luogo_arrivo, Veicolo veicolo){
        //creo una Queue che sarà il mio percorso
        Queue<NodoEsteso> percorso_queue = new PriorityQueue<>();
        //creo una Map che associa al Luogo il suo NodoEsteso, ovvero il Luogo con le info aggiuntive
        //questa map salverà tutti i luoghi visitati fin ora
        Map<Luogo, NodoEsteso> nodi_visitati = new HashMap<>();
        double carburante = calcolaCarburante(luogo_partenza, luogo_arrivo, veicolo.getTipologia());
        //creo il primo nodo con formazioni aggiuntive, sarà il nodo di luogo_partenza
        NodoEsteso nodo_partenza = new NodoEsteso(luogo_partenza, null, 0d, carburante);
        //lo aggiungo al percorso
        percorso_queue.add(nodo_partenza);
        //lo aggiungo ai nodi visitati
        nodi_visitati.put(luogo_partenza, nodo_partenza);

        //ciclo fino a quando ci sono elementi
        while (!percorso_queue.isEmpty()){

            //prelevo il primo nodo della coda(quello più vicino alle rovine perdute)
            NodoEsteso nodo_ripartenza = percorso_queue.poll();
            //controllo che il luogo selezionato corrisponda al luogo di arrivo
            if(nodo_ripartenza.getLuogo_corrente().equals(luogo_arrivo)){
                ArrayList<Luogo> strada = new ArrayList<>();
                NodoEsteso nodo_corrente = nodo_ripartenza;
                do{
                    //inserisco ogni elemento in pos 0, affinchè gli altri si spostino di una pos avanti nell'arraylist
                    strada.add(0, nodo_corrente.getLuogo_corrente());
                    //il nodo corrente diventa il nodo precedente
                    nodo_corrente = nodi_visitati.get(nodo_corrente.getLuogo_precedente());
                }while (nodo_corrente != null);
                //ritornerà un arrayList contenente il percorso dal campo base fino alle rovinePerdute
                return strada;
            }
            //salvo il luogo del nodo da dove ero ripartito(ovvero il suo luogo esteso)
            Luogo luogo_nodo_ripartenza = nodo_ripartenza.getLuogo_corrente();

            Set<Luogo> luoghi_connessi_al_nodo_ripartenza = grafo.getArchi(luogo_nodo_ripartenza);
            luoghi_connessi_al_nodo_ripartenza.forEach(
                    luogo_connesso -> {
                        //estendo il luogo appena analizzato nei luoghi connessi al luogo di ripartenza
                        NodoEsteso nodo_esteso_default = new NodoEsteso(luogo_connesso);
                        //nodo del luogo_connesso, in caso non ci sia diventa un nodo esteso tramite il costruttore di default
                        NodoEsteso nodo_connesso = nodi_visitati.getOrDefault(luogo_connesso, nodo_esteso_default);
                        //aggiunta del nodo visitato
                        nodi_visitati.put(luogo_connesso, nodo_connesso);
                        double carburante_tappa_singola =  calcolaCarburante(nodo_ripartenza.getLuogo_corrente(), luogo_connesso, veicolo.getTipologia());
                        double carburante_fino_connessione = nodo_ripartenza.getCarburante_utilizzato() + carburante_tappa_singola;

                        /*se sono già arrivato precedentemente al nodo connesso utilizzando meno carburante, allora non sarà la strada giusta
                          inizialmente il carburante utilizzato è = infininto, ogni volta che posso raggiungere il nodo conneso con meno carburante
                          allora aggiornerò il carburante utilizzato ad arrivare fino li, aggiornerò il luogo da dove arrivo al nodo connesso, ovvero
                          il nodo in cui mi trovo, e aggiorno il carburante stimato fino all'arrivo, infine aggiungo il nodo al percorso
                         */
                        if(carburante_fino_connessione < nodo_connesso.getCarburante_utilizzato()){
                            nodo_connesso.setLuogo_precedente(nodo_ripartenza.getLuogo_corrente());
                            nodo_connesso.setCarburante_utilizzato(carburante_fino_connessione);
                            nodo_connesso.setCarburante_stimato(carburante_fino_connessione + calcolaCarburante(luogo_connesso, luogo_arrivo, veicolo.getTipologia()));
                            percorso_queue.add(nodo_connesso);
                        }
                    }
            );
        }
        throw new IllegalStateException(Costanti.ERRORE_STRADA);
    }

    private static double calcolaCarburante(Luogo luogo_partenza, Luogo luogo_arrivo, String tipologia){
        switch (tipologia){
            case Costanti.METZTLI:
                int h1 = luogo_partenza.getPosizione().getH();
                int h2 = luogo_arrivo.getPosizione().getH();
                return Math.abs(h1-h2);
            case Costanti.TONATHIU: //distanza euclidea
                int x1 = luogo_partenza.getPosizione().getX();
                int x2 = luogo_arrivo.getPosizione().getX();
                int y1 = luogo_partenza.getPosizione().getY();
                int y2 = luogo_arrivo.getPosizione().getY();
                return (Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)));
            default: throw new IllegalArgumentException(Costanti.ERRORE_TIPOLOGIA);
        }
    }
}
