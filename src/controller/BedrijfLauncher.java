package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {
    public static void main(String[] args) {

        Afdeling[] afdelingen = new Afdeling[4]; //7a
        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
        afdelingen[1] = new Afdeling("Support", "Amsterdam");
        afdelingen[2] = new Afdeling("Management", "Almere");
        afdelingen[3] = new Afdeling("Documentatie", "Gouda");

        // 7b) Een werknemer met de naam baas aanmaken
        Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        // 7c) Een werknemer met de naam medewerker aanmaken
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000.00);
        // 7d) Een zzp-er met de naam assistent aanmaken
        Zzper assistent = new Zzper("Klaas", "Diemen", afdelingen[3], 50.00, 00);
        Zzper projectleider = new Zzper("Ronald", "Zaandam", afdelingen[0], 80,00);
        // 7e) Klaas inhuren voor 160 uur
        assistent.huurIn(160);
        projectleider.huurIn(320);



        // Maak een array van de klasse Persoon
        Persoon[] personen = new Persoon[4];
        personen[0] = baas;
        personen[1] = assistent;
        personen[2] = medewerker;
        personen[3] = projectleider;


        // Roep de toonJaarInkomen-methode aan voor elk persoon in de array
        for (Persoon persoon : personen) {
            toonJaarInkomen(persoon);
        }
    }

    // Methode om jaarinkomen van een persoon weer te geven
    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }


}

