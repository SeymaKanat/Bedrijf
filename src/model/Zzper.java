package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
public class Zzper extends Persoon {
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = 0;
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





    public double getUurtarief() {
        return uurtarief;
    }

    public void setUurtarief(double uurtarief) {
        this.uurtarief = uurtarief;
    }

    public int getUrenGewerkt() {
        return urenGewerkt;
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }
}
