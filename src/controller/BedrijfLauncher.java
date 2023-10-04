package controller;


import database.AfdelingDAO;
import database.DBaccess;
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
    public static void main(String[] args) {
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);

        dBaccess.openConnection(); // yazmazsan error alirsin
//        afdelingDAO.slaAfdelingOp(new Afdeling("HR", "Hilversum"));// yeniden HR uretmemesi icin yoruma aldik

        System.out.println(afdelingDAO.geeftAfdelingen("Hilversum"));
    }

    }











