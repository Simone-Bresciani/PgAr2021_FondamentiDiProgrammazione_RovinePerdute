package it.unibs.arnaldo.rovinePerdute;

import java.util.Comparator;

public class ComparatoreNodi implements Comparator<NodoEsteso> {

    @Override
    public int compare(NodoEsteso nodo_prec, NodoEsteso nodo_succ) {
        if (nodo_prec.getCarburante_stimato() < nodo_succ.getCarburante_stimato()) {
            return -1;
        } else if (nodo_prec.getCarburante_stimato() > nodo_succ.getCarburante_stimato()) {
            return 1;
        }
        /*
        else if (nodo_prec.getLuogo_corrente().getId() > nodo_succ.getLuogo_corrente().getId()){
            return -1;
        }else if(nodo_prec.getLuogo_corrente().getId() < nodo_succ.getLuogo_corrente().getId()){
            return 1;
        }*/
        return 0;
    }
}
