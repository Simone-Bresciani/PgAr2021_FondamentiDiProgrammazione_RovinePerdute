package it.unibs.arnaldo.rovinePerdute;

import javax.print.StreamPrintServiceFactory;
import java.util.regex.PatternSyntaxException;

public class Costanti {

    //GESTIONE FILE XML
    //nomi file
    public static final String FILE_5_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_5.xml";
    public static final String FILE_12_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_12.xml";
    public static final String FILE_50_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_50.xml";
    public static final String FILE_200_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_200.xml";
    public static final String FILE_2000_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_2000.xml";
    public static final String FILE_10000_CITTA = "src/it/unibs/arnaldo/rovinePerdute/test_file/PgAr_Map_10000.xml";
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
    //comunicazioni di inzio lettura file
    public static final String INZIO_LETTURA_DOC = "Inzio a leggere il file: %s ...\n";
    //errori vari
    public static final String ERRORE_INIZIALIZZAZIONE_READER = "Errore nell'inizializzazione del reader: ";
    public static final String ERRORE_LETTURA_FILE = "Errore nella lettura del file: %s, per ulteriori info: %s\n";
    public static final String ERRORE_STRADA = "Errore strada non trovata :(";

    //GESTIONE MAIN
    public static final String ERR_ID_NON_TROVATO = "id non trovato:(";
    public static final String TONATHIU = "tonathiu";
    public static final String METZTLI = "metztli";

}
