package controller;


import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {
    public static void main(String[] args) { //9.1.4 start
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        File afdelingenBestand = new File("resources/Afdelingen.txt");//9.4

        try {
            Scanner input = new Scanner(afdelingenBestand);
            while (input.hasNextLine()) {
                String afdelingNaam = input.nextLine();
                String afdelingPlaats = input.nextLine();
                afdelingen.add(new Afdeling(afdelingNaam, afdelingPlaats));
            }
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
//        9.1 .4 finished.

        //9.1.5 start
        ArrayList<Persoon> personen = new ArrayList<>();
        File personenBestand = new File("resources/Personen.csv");
        try (Scanner input = new Scanner(personenBestand);) {
            while (input.hasNextLine()) {
                String[] persoonsinfo = input.nextLine().split(",");

                String type = persoonsinfo[0];
                String naam = persoonsinfo[1];
                String woonplaats = persoonsinfo[2];

                int indexArrayListAfdelingen = Integer.parseInt(persoonsinfo[3]);
                Afdeling afdeling = afdelingen.get(indexArrayListAfdelingen);
                double maandSalarisUurtariefNul = Double.parseDouble(persoonsinfo[4]);


                switch (type) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdeling, maandSalarisUurtariefNul));
                        break;
                    case "Zzper":
                        personen.add(new Zzper(naam, woonplaats, afdeling, maandSalarisUurtariefNul));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdeling));
                        break;
                    default:
                        System.out.printf("%s is geen geldig persoonstype, deze regel slaan we over", type);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het lukte niet om het personen bestand te vinden");
        }

        Collections.sort(personen);

        File uitvoerbestand = new File("resources/PersonenPerAfdeling.txt");
        try (PrintWriter writer = new PrintWriter(uitvoerbestand)) {
            for (Afdeling afdeling : afdelingen) {
                writer.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        writer.printf("-- %s\n", persoon);
                    }
                }

                writer.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het lukte niet om het uitvoerbestand te openen");
        }
    }
}










