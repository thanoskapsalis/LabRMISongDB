package com.company;

import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class Controller {

    Connection conn;
    Statement stat;

    public Controller() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            stat = conn.createStatement();
            System.out.println("Conncction established;");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public boolean Insert_Song(_Song_toAdd song) {
        try {
            if(Check(song))
            {
                String message = "INSERT INTO songs (TITLE,TYPE,SINGER,DURATION,STARS) VALUES" +
                        " ('" + song.getTitle() + "','" + song.getType() + "','" + song.getSinger() + "','" + song.getDuration() + "','" + song.getStars() + "')";
                System.out.println(message);
                stat.executeUpdate(message);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean Check(_Song_toAdd song) throws SQLException {
        ResultSet records=null;
       records=stat.executeQuery("SELECT TITLE,SINGER FROM songs WHERE (TITLE='"+ song.getTitle()+"' AND SINGER='"+song.getSinger()+"')");
        System.out.println(records.next());
        if(records.next())
            return false;
        return true;
    }
}
