package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {
    public static void main(String[] args) {
        File afdelingenBestand = new File("resources/Afdelingen.txt");//9.4
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        try {
            Scanner input = new Scanner(afdelingenBestand);
            while (input.hasNextLine()){
                String afdelingNaam = input.nextLine();
                String afdelingPlaats = input.nextLine();
                afdelingen.add(new Afdeling(afdelingNaam, afdelingPlaats));
            }
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        ArrayList<Persoon> personen = new ArrayList<>(); //9.5
        File personenBestand = new File("resources/Personen.csv");
        try {
            Scanner input = new Scanner(personenBestand);
            while (input.hasNextLine()) {
                String[] regelArray = input.nextLine().split(",");
                String typePersoon = regelArray[0];
                String naam = regelArray[1];
                String woonplaats = regelArray[2];
                int indexArrayListAfdelingen = Integer.parseInt(regelArray[3]);
                double maandSalarisUurtariefNul = Double.parseDouble(regelArray[4]);

                if (typePersoon.equals("Werknemer")) {
                    personen.add(new Werknemer(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen), maandSalarisUurtariefNul));
                } else if (typePersoon.equals("Zzper")) {
                    personen.add(new Zzper(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen), maandSalarisUurtariefNul));
                } else if (typePersoon.equals("Vrijwilliger")) {
                    personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen)));
                }

//                switch (typePersoon) {
//                    case "Werknemer":
//                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen),
//                                maandSalarisUurtariefNul));
//                        break;
//                    case "Zzper":
//                        personen.add(new Zzper(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen),
//                                maandSalarisUurtariefNul));
//                        break;
//                    case "Vrijwilliger":
//                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(indexArrayListAfdelingen)));
//                        break;
//                }
            }
        }catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        Collections.sort(personen); //Collections.sort yöntemi, varsayılan olarak "Persoon" sınıfının compareTo metodunu kullanarak sıralama işlemini gerçekleştirir.
        for (Persoon persoon : personen) {
            System.out.println(persoon);
        }

        File uitvoerBestand = new File("resources/PersonenPerAfdeling.txt");
        try {
            PrintWriter printWriter = new PrintWriter(uitvoerBestand);
            for (Afdeling afdeling: afdelingen) { //"printWriter" ile "Afdeling" nesnesinin adını metin dosyasına yazar. Bu, her bir afdelinin adının başlık olarak yazılmasını sağlar.
                printWriter.println("Afdeling: " + afdeling.getAfdelingsNaam());
                for (Persoon persoon: personen){
                    if (persoon.getAfdeling() == afdeling){
                        printWriter.println(("-- " + persoon));
                    }
                }
                printWriter.println();
            }
            printWriter.close();
        } catch (FileNotFoundException nietGemaakt) {
            System.out.println("Het bestand kan niet worden aangemaakt.");
        }



//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Geef de naam: ");
//        String naam = input.nextLine();
//
//        System.out.print("Geef de woonplaats: ");
//        String woonplaats = input.nextLine();
//
//        System.out.print("Geef de naam van de afdeling: ");
//        String afdelingNaam = input.nextLine();
//
//        System.out.print("Geef de plaats van de afdeling: ");
//        String afdelingPlaats = input.nextLine();
//
//        Afdeling afdeling = new Afdeling(afdelingNaam, afdelingPlaats);
//        Werknemer werknemer = null;
//
//        while (werknemer == null) {
//            System.out.print("Geef het maandsalaris: ");
//            double maandSalaris = input.nextDouble();
//
//            try {
//                werknemer = new Werknemer(naam, woonplaats,afdeling, maandSalaris);
//                System.out.println(werknemer);
//            } catch (IllegalArgumentException IllegalArgumentException) {
//                System.out.println(IllegalArgumentException.getMessage());
//            } finally {
//                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
//
//
//            }
//        }

//    }
//}


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



    }
}
