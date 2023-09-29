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

    public static int aantalPersonen;
    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;

    private Afdeling afdeling; //// Hier voeg ik het afdeling attribuut toe

    public Persoon(String naam, String woonplaats, double maandSalaris, Afdeling afdeling) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandSalaris(maandSalaris);
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;


    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAANDSALARIS, new Afdeling());
    }

     public Persoon() {
        this("Onbekend");
    }

    public double berekenJaarInkomen() {
        return DEFAULT_AANTALMAAND * maandSalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
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

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            System.out.println("Het maandsalaris mag niet negatief zijn. Het wordt op 0 gezet.");
            this.maandSalaris = 0.0;
        } else {
            this.maandSalaris = maandSalaris;
        }
    }
    public Afdeling getAfdeling() { //3c
        return afdeling;
    }
    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

}