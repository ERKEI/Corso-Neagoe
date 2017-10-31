import java.util.StringTokenizer;
/**
 * Descrizione di un Track. 
 * Si deve prevedere un costruttore che ha come parametro una stringa con 
 * i campi separate da un carattere '|'
 * 
 * @author lorenzo
 * @version 25/10/2017
 */
public class Track
{
    private final String FIELD_SEP = "|";
    
    private String codice;
    private String autore;
    public static String titolo;
    private double prezzo;

    /**
     * Costruttore completo
     * 
     */
    public Track(String codice, String autore, String titolo, double prezzo)
    {
        this.codice = codice;
        this.autore = autore;
        this.titolo = titolo;
        this.prezzo = prezzo;
    }
    
    /**
     * costruttore senza parametri
     */
    public Track()
    {
        this("","","",0.0);   
    }
    
    /**
     * costruttore con un parametro stringa. 
     * I campi vengono estratti dalla stringa 
     * I campi sono separati da un carattere specificato
     */
    public Track(String elenco)
    {
        StringTokenizer t = new StringTokenizer(elenco, FIELD_SEP);
        this.codice = t.nextToken();
        this.autore = t.nextToken();
        this.titolo = t.nextToken();
        this.prezzo = Double.parseDouble(t.nextToken());
    }
    
    public static String getTitolo()
    {
        return titolo;
    }
    
    public String toString()
    {
        return codice + "|" +
               autore + "|" +
               titolo + "|" +
               prezzo;
    }
    
}
