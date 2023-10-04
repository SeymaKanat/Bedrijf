package database;


import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            System.out.println(preparedStatement);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            System.out.println(preparedStatement);
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();// Bu cok onemli.Yazmazsan guncellemez.
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public ArrayList<Afdeling> geeftAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                String afdelingsPlaats = resultSet.getString("afdelingsplaats");

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));


            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }


        return afdelingen;
    }

    public ArrayList<Afdeling> geeftAfdelingen(String plaats) { //10.10
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling WHERE afdelingsplaats = ?;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, plaats);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                String afdelingsPlaats = resultSet.getString("afdelingsplaats");

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));


            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }


        return afdelingen;
    }



}
