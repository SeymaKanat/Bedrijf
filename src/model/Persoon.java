package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Een persoon betrakken bij ond bedrijf
 */
public class Persoon {
    private final static double GRENSWAARDE_BONUS = 4500.00;
    private static final int DEFAULT_MAANDSALARIS = 0;
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_AANTALMAAND = 12;
    private static final String DEFAULT_NAAM = "Onbekend";

    public static int aantalPersonen;
    protected final static String DEFAULTWAARDE_NAAM = "Onbekend";
    protected final static String DEFAULTWAARDE_WOONPLAATS = "Onbekend";
    protected int personeelsNummer;
    protected String naam;
    protected String woonplaats;
    protected Afdeling afdeling;


    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULTWAARDE_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarInkomen() {
        return 0;
    }
    @Override
    public String toString() {
        return naam + " woont in " + woonplaats + " en werkt op " + afdeling;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public void setPersoneelsNummer(int personeelsNummer) {
        this.personeelsNummer = personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}







