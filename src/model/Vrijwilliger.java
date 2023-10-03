package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 *beschrijft iemand die vrijwilliger voor ons bedrijf werkt
 */
public class Vrijwilliger extends Persoon {
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }
    @Override
    public void huurIn(int uren) {
    } //7.5.a.Voeg de methode huurIn toe.


    @Override
    public double berekenJaarInkomen() {
        return 0; //7.5.a De methode berekenJaarInkomen() geeft altijd 0.
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }
}



