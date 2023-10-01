package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 *  Eigenschappen van die personen die in vaste dienst zijn bij mijn bedrijf
 */
public class Werknemer extends Persoon {
    private static final double DEFAULT_MAAND_SALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;
    private static double GRENSWAARDE_BONUS = 4500.00;
    private double maandSalaris;

    //Constructors
    public Werknemer(String naam, String woonplaats, Afdeling afdeling,double maandSalaris) {
        super(naam, woonplaats, afdeling);
        this.maandSalaris = maandSalaris;
    }

    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        super();
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
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
    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op bonus",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }


    private void setMaandsalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            System.err.printf("Het maandsalaris mag niet negatief zijn! Het maandsalaris wordt op %.1f gezet.\n",
                    DEFAULT_MAAND_SALARIS);
            this.maandSalaris = DEFAULT_MAAND_SALARIS;

        } else {
            this.maandSalaris = maandSalaris;
        }
    }
}


