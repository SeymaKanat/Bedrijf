package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 *  Eigenschappen van die personen die in vaste dienst zijn bij mijn bedrijf
 */
public class Werknemer extends Persoon {
    private static final double DEFAULT_MAAND_SALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;
    private static final int MAAND_SALARIS = 0;
    private static double GRENSWAARDE_BONUS = 4500.00;
    private double maandSalaris;

    //Constructors
    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        setMaandsalaris(maandSalaris);
    }



    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        super();
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
    }

    @Override
    public void huurIn(int uren) {
        maandSalaris += uren * MAANDEN_PER_JAAR;
    }


    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarInkomen() {
        double jaarinkomen = MAANDEN_PER_JAAR * maandSalaris;

        if (heeftRechtOpBonus()) {
            jaarinkomen += maandSalaris;
        }

        return jaarinkomen;
    }
    @Override //8.5
    public String toString() {
        return String.format("%s en is een werknemer %s recht op bonus",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }

    private void setMaandsalaris(double maandSalaris) { //8.2
        if (maandSalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn"); //8.2.a.Voeg de methode setMaandsalaris toe
        }
            this.maandSalaris = maandSalaris;
        }
    }



