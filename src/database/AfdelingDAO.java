package database;


import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public  void slaAfdelingOp(Afdeling afdeling) {
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

}