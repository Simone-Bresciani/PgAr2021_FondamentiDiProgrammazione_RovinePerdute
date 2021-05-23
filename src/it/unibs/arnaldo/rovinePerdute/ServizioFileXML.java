package it.unibs.arnaldo.rovinePerdute;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ServizioFileXML {

    public static ArrayList<Luogo> leggiMappa(String filename){
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlreader = null;
        //creo l'arraylist dei luoghi che il metodo ritornerà
        ArrayList<Luogo> lista_luoghi = new ArrayList<>();

        //try catch per gestire eventuali eccezioni durante l'inizializzazione
        try{
            xmlif=XMLInputFactory.newInstance();
            xmlreader= xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        }catch(Exception e){
            System.out.println(Costanti.ERRORE_INIZIALIZZAZIONE_READER);
            System.out.println(e.getMessage());
        }

        //try catch per gestire errori durante la lettura dei luoghi
        try {
            //esegue finchè ha eventi ha disposizione
            while (xmlreader.hasNext()){

                //creo il nuovo_luogo e la posizione
                Luogo nuovo_luogo = null;
                Posizione pos = null;
                ArrayList<Integer> connessioni = null;

                //switcho gli eventi letti
                switch (xmlreader.getEventType()){

                    //evento inzio lettura documento
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.printf(Costanti.INZIO_LETTURA_DOC, filename);
                        break;

                    //evento di inzio lettura elemento
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.printf(Costanti.INIZIO_LETTURA_ELEMENTO);
                        //switcho i vari tipi di elementi
                        switch (xmlreader.getLocalName()){

                            //lettura tag <map ....>
                            case Costanti.MAP:
                                System.out.println(xmlreader.getLocalName());
                                //comunico il numero di luoghi da analizzare
                                System.out.printf(Costanti.LETTURA_NUMERO_LUOGHI, Integer.parseInt(xmlreader.getAttributeValue(0)));
                                break;

                            //lettura tag <city ...>
                            case Costanti.CITY:
                                System.out.println(xmlreader.getLocalName());
                                //quando entro nel tag city vuol dire che ho una nuova città da aggiungere, quindi resetto i parametri del luogo, pos e connessioni
                                connessioni = null;
                                nuovo_luogo = null;
                                pos = null;
                                //itero sul numero di attributi presenti nel tag (anche se sono sempre 5)
                                for (int i=0; i<xmlreader.getAttributeCount(); i++){
                                    //switcho sui tipi di attributi
                                    switch (xmlreader.getAttributeLocalName(i)){
                                        //attributo id
                                        case Costanti.ID:
                                            //aggiungo l'id, visto che ritorna una stringa dal metodom faccio il cast
                                            nuovo_luogo.setId(Integer.parseInt(xmlreader.getAttributeValue(i)));
                                            break;
                                        //attributo name
                                        case Costanti.NAME:
                                            //aggiungo il nome
                                            nuovo_luogo.setNome(xmlreader.getAttributeValue(i));
                                            break;
                                        //attributo x
                                        case Costanti.X:
                                            pos.setX(Integer.parseInt(xmlreader.getAttributeValue(i)));
                                            break;
                                        //atributo y
                                        case Costanti.Y:
                                            pos.setX(Integer.parseInt(xmlreader.getAttributeValue(i)));
                                            break;
                                        //attributo h
                                        case Costanti.H:
                                            pos.setX(Integer.parseInt(xmlreader.getAttributeValue(i)));
                                            break;
                                    }
                                }
                                //uscito dal for aggiungo la posizione al luogo
                                nuovo_luogo.setPosizione(pos);
                                break;

                            //lettura tag <link ...>
                            case Costanti.LINK:
                                System.out.println(xmlreader.getLocalName());
                                //aggiungo l'id all'arraylist delle connessioni, ovviamente bisogna castare il return del metodo
                                connessioni.add(Integer.parseInt(xmlreader.getAttributeValue(0))); //è sempre al primo posto, essendo l'unico
                                break;
                        }

                        //evento di fine lettura elemento
                    case XMLStreamConstants.END_ELEMENT:
                        //se siamo al tag di chiusura della città, aggiunge le connessioni al nuovo_luogo
                        //e aggiungo il luogo all'arraylist
                        if(xmlreader.getLocalName().equals(Costanti.CITY)){
                            nuovo_luogo.setConnessioni(connessioni);
                            lista_luoghi.add(nuovo_luogo);
                        }
                        System.out.printf(Costanti.FINE_LETTURA_ELEMENTO, xmlreader.getLocalName());
                        break;
                }
                xmlreader.next();
            }
        } catch (XMLStreamException e) {
            System.out.printf(Costanti.ERRORE_LETTURA_FILE, filename, e.getMessage());
        }
        return lista_luoghi;
    }
}
