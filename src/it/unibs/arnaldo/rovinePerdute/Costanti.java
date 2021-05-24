package it.unibs.arnaldo.rovinePerdute;

import javax.print.StreamPrintServiceFactory;
import java.util.regex.PatternSyntaxException;

public class Costanti {

    //GESTIONE FILE XML

    //tag
    public static final String MAP = "map";
    public static final String CITY = "city";
    public static final String LINK = "link";
    //attributi dei tag
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String X = "x";
    public static final String Y = "y";
    public static final String H = "h";
    //comunicazioni di inzio/fine eventi
    public static final String INZIO_LETTURA_DOC = "Inzio a leggere il file: %s ...\n";
    public static final String INIZIO_LETTURA_ELEMENTO = "Lettura tag: ";
    public static final String FINE_LETTURA_ELEMENTO = "Chiusura tag: %s\n";
    //comuniazioni attributi
    public static final String LETTURA_NUMERO_LUOGHI = "Sono presenti %d luoghi\n";
    public static final String LETTURA_NOME_LUOGO = "nome luogo: %s\n";
    public static final String LETTURA_ID_LUOGO = "id del luogo: %d\n";
    public static final String LETTURA_COO_LUOGO = "valore della coordinata %s: %d\n";
    public static final String LETTURA_CONNESSIONE_LUOGO = "si connette al luogo con id: %d\n";
    //errori vari
    public static final String ERRORE_INIZIALIZZAZIONE_READER = "Errore nell'inizializzazione del reader: ";
    public static final String ERRORE_LETTURA_FILE = "Errore nella lettura del file: %s, per ulteriori info: %s\n";
}
