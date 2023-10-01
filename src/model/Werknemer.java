package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
public class Werknemer extends Persoon {
    private static double GRENSWAARDE_BONUS = 4500.00;
    private double maandSalaris;

    //Constructors
    public Werknemer(String naam, String woonplaats, Afdeling afdeling,double maandSalaris) {
        super(naam, woonplaats, afdeling);
        this.maandSalaris = maandSalaris;
    }

    public Werknemer(String naam) {
        this(naam, DEFAULTWAARDE_WOONPLAATS, new Afdeling(),0.0);
    }

    public Werknemer() {
        this(DEFAULTWAARDE_NAAM);
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    public double berekenJaarInkomen() {
        if (heeftRechtOpBonus()) {
            return 13 * maandSalaris;
        } else {
            return 12 * maandSalaris;
        }

    }
    @Override
    public String toString() {
        String rechtOpBonus;
        if (heeftRechtOpBonus()) {
            rechtOpBonus = " met recht op een bonus" ;
        } else {
            rechtOpBonus = " zonder recht op een bonus";
        }
        return super.toString() + " en is een werknemer" + rechtOpBonus ;
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
}


