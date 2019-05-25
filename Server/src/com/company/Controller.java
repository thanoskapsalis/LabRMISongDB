package com.company;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;


public class Controller {

    Connection conn;
    Statement stat;
    public static ArrayList<String> returned = new ArrayList<>();

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
            if (Search(song, null)) {
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

    public boolean Search(_Song_toAdd song, String flag) throws SQLException {
        ResultSet records = null;
        System.out.println("Search Request");
        if (flag.equals(null)) {
            records = stat.executeQuery("SELECT TITLE,SINGER FROM songs WHERE (TITLE='" + song.getTitle() + "' AND SINGER='" + song.getSinger() + "')");
            System.out.println(records.next());
            if (records.next())
                return false;
            return true;
        } else {
            switch (flag) {
                case "title":
                    records = stat.executeQuery("SELECT * FROM songs WHERE (TITLE='" + song.getTitle() + "')");
                    break;
                case "singer":
                    records = stat.executeQuery("SELECT * FROM songs WHERE (SINGER='" + song.getSinger() + "')");
                    break;
            }
            while(records.next()) {
                String title=records.getString("TITLE");
                String singer=records.getString("SINGER");
                String duration=records.getString("DURATION");
                int stars=records.getInt("STARS");
                returned.add(title+"\t"+singer+"\t"+duration+"\t"+stars);
                return true;

            }
            return false;
        }


    }


}
