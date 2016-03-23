package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mike on 19.03.2016.
 */
public class SQLiteConnection {


    private static Connection con;


    public static Connection getConnection() {

        try {
           Class.forName("org.sqlite.JDBC").newInstance();

           String url = "jdbc:sqlite:c:\\Users\\Mike\\AndroidStudioProjects\\DataBase\\FinanceManager\\mony.db";

           if (con == null) con = DriverManager.getConnection(url);

        return con;
    } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
