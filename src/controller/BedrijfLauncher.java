package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
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
        Zzper assistent = new Zzper("Klaas", "Diemen", afdelingen[3], 50.00);
        // 7e) Klaas inhuren voor 160 uur
        assistent.huurIn(160);

        System.out.println("Het aantal personen in het bedrijf is "+ Persoon.aantalPersonen);
        System.out.println(baas);
        System.out.println(medewerker);
        System.out.println(assistent);
        System.out.printf("%s verdient %.2f per jaar\n", baas.getNaam(), baas.berekenJaarInkomen());
        System.out.printf("%s verdient %.2f per jaar\n", medewerker.getNaam(), medewerker.berekenJaarInkomen());
        System.out.printf("%s verdient %.2f per jaar\n", assistent.getNaam(), assistent.berekenJaarInkomen());


    }
}
