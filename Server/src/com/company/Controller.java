package com.company;
import java.sql.*;


public class Controller {

    public Controller(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            Statement stat = conn.createStatement();
            System.out.println("Conncction established;");
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
    }

}
