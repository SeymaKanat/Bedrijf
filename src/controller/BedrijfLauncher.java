package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

import java.util.ArrayList;

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

        ArrayList<Persoon> mijnPersonen = new ArrayList<>();

        // 6.3 Vul de ArrayList met gegeven gegevens
        mijnPersonen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
        mijnPersonen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
        mijnPersonen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
        mijnPersonen.add(new Zzper("Klaas", "Diemen", afdelingen[3], 50.00));
        mijnPersonen.add(new Zzper("Ronald", "Zaandam", afdelingen[0], 80.00));
        mijnPersonen.add(new Zzper("Jannie", "Utrecht", afdelingen[0], 60.00));
        mijnPersonen.add(new Zzper("Anne", "Zwolle", afdelingen[0], 40.00));

        //6.5) Gebruik een for-loop met instanceof en typecasting om alle zzp-ers in de arraylist voor 320
        //uur in te huren.

        for (Persoon persoon : mijnPersonen) {
            if (persoon instanceof Zzper) {
                ((Zzper) persoon).huurIn(320);
            }

        }
        //6.6) Gebruik een for-loop en de al bestaande methode toonJaarInkomen()
        for (Persoon persoon : mijnPersonen) {
            toonJaarInkomen(persoon);

        }

        // Maak een array van de klasse Persoon
        Persoon[] personen = new Persoon[4];

    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }


    }







