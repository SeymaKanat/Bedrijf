package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = input.nextLine();

        System.out.print("Geef de woonplaats: ");
        String woonplaats = input.nextLine();

        System.out.print("Geef de naam van de afdeling: ");
        String afdelingNaam = input.nextLine();

        System.out.print("Geef de plaats van de afdeling: ");
        String afdelingPlaats = input.nextLine();

        Afdeling afdeling = new Afdeling(afdelingNaam, afdelingPlaats);
        Werknemer werknemer = null;

        while (werknemer == null) {
            System.out.print("Geef het maandsalaris: ");
            double maandSalaris = input.nextDouble();

            try {
                werknemer = new Werknemer(naam, woonplaats,afdeling, maandSalaris);
                System.out.println(werknemer);
            } catch (IllegalArgumentException IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");


            }
        }

    }
}


//        Afdeling[] afdelingen = new Afdeling[4];
//        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
//        afdelingen[1] = new Afdeling("Support", "Amsterdam");
//        afdelingen[2] = new Afdeling("Management", "Almere");
//        afdelingen[3] = new Afdeling("Documentatie", "Gouda");
//        ArrayList<Persoon> personen = new ArrayList<>();
//        personen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
//        personen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
//        personen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
//        personen.add(new Zzper("Klaas", "Diemen", afdelingen[3], 50.00));
//        personen.add(new Zzper("Ronald", "Zaandam", afdelingen[0], 80.00));
//        personen.add(new Zzper("Jannie", "Utrecht", afdelingen[0], 60.00));
//        personen.add(new Zzper("Anne", "Zwolle", afdelingen[0], 40.00));
//        personen.add(new Vrijwilliger("Ambi", "Amsterdam", afdelingen[0]));
//        personen.add(new Vrijwilliger("Naledi", "Gaborone", afdelingen[1]));
//        personen.add(new Vrijwilliger("Ceren", "Istanboel", afdelingen[2]));
//        personen.add(new Vrijwilliger("Haining", "Shaoxing", afdelingen[3]));
//        //6.5) Gebruik een for-loop met instanceof en typecasting om alle zzp-ers in de arraylist voor 320
//        //uur in te huren.
//
//        for (Persoon persoon : personen) {
//            if (persoon instanceof Zzper) {
//                ((Zzper) persoon).huurIn(320);
//            }
//
//        }//7.6.b.
//        for (Persoon persoon : personen) {
//            if (persoon instanceof Zzper) {
//                ((Zzper) persoon).huurIn(320);
//            } else if (persoon instanceof Vrijwilliger) {
//                ((Vrijwilliger) persoon).huurIn(160);
//            }
//
//        }
//        for (Persoon persoon : personen) {
//            if (persoon instanceof Oproepbaar) {
//                ((Oproepbaar) persoon).huurIn(320);
//            }
//            if (persoon instanceof Zzper) {
//                ((Zzper) persoon).huurIn(160);
//            }//vraag!! dit is opsie
//
//
//        }
//        //7.6. Sorteer de ArrayList op alfabetische volgorde
//        Collections.sort(personen);
//
//        for (Persoon persoon : personen) {
//            System.out.println(persoon);
//            toonJaarInkomen(persoon);
//        }
//
//    }
//
//    public static void toonJaarInkomen (Persoon persoon){
//        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
//    }






