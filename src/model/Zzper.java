package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Beschrijft een zelfstandige die door ons bedrijf ingehuurd wordt.
 */
public class Zzper extends Persoon {
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief, int i) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }
    // Methode om jaarinkomen te berekenen
    public double berekenJaarInkomen() {
        return uurtarief * urenGewerkt;
    }

    public void huurIn(int uren) {
        urenGewerkt += uren;
    }
    @Override
    public String toString() {
        return super.toString() + " en is een zzp-er met een uurtarief van " + uurtarief;

    }
}
