package model;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Een afdeling binnen mijn bedrijf
 */
public class Afdeling {
    private static final String DEFAULT_AFDELINGNAAM = "onbekend";
    private static final String DEDAULT_AFDELINGSPLAATS = "onbekend";
    private String afdelingsNaam;
    private String afdelingsPlaats;


    public Afdeling(String afdelingsNaam, String afdelingsPlaats) {
        this.afdelingsNaam = afdelingsNaam;
        this.afdelingsPlaats = afdelingsPlaats;
    }

    public Afdeling(String afdelingsNaam) {
        this(afdelingsNaam, "onbekend");
    }
    public Afdeling() {
        this(DEFAULT_AFDELINGNAAM, DEDAULT_AFDELINGSPLAATS);
    }

    // toString() methode
    @Override //3a
    public String toString() {
        return "afdeling " + afdelingsNaam + " te " + afdelingsPlaats;
    }

    public String getAfdelingsNaam() {
        return afdelingsNaam;
    }

    public void setAfdelingsNaam(String afdelingsNaam) {
        this.afdelingsNaam = afdelingsNaam;
    }

    public String getAfdelingsPlaats() {
        return afdelingsPlaats;
    }

    public void setAfdelingsPlaats(String afdelingsPlaats) {
        this.afdelingsPlaats = afdelingsPlaats;
    }
}
