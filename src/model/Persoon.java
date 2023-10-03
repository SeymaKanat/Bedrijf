package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Een persoon betrokken bij ons bedrijf
 */
public abstract class Persoon implements Comparable<Persoon>  { //7.2.a Voeg de interface Comparable toe.



    private static final String DEFAULT_NAAM = "Onbekend";
    private final static String DEFAULTWAARDE_WOONPLAATS = "Onbekend";

    private static int aantalPersonen = 0;

    private final int personeelsnummer;
    private final String naam;
    private final String woonplaats;
    private final Afdeling afdeling;


    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;

    }

    public Persoon(String naam) {
        this(naam, DEFAULTWAARDE_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public abstract void huurIn(int uren) //7.5.a.Voeg de methode huurIn toe.
    ;

    public abstract double berekenJaarInkomen();

    @Override // 7.2.bVoeg de methode compareTo() toe,
    public int compareTo(Persoon anderePersoon) {
        return this.naam.compareTo(anderePersoon.naam);// benim adimi baska personel adiyla kiyasla demekmis

    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }



    public int getPersoneelsnummer() {
        return personeelsnummer;
    }
    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }



}







