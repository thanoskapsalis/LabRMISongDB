package com.company;

import javax.print.DocFlavor;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;


public class Controller {

    Connection conn;
    Statement stat;
    public static ArrayList<String> returned = new ArrayList<>();
    public static ArrayList<Integer> returned2 = new ArrayList<>();

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
            if (Check(song)) {
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
        ResultSet records = null;
        records = stat.executeQuery("SELECT TITLE,SINGER FROM songs WHERE (TITLE='" + song.getTitle() + "' AND SINGER='" + song.getSinger() + "')");
        System.out.println(records.next());
        if (records.next())
            return false;
        return true;
    }


    public ArrayList Search(String song, String flag) {
        try {
            ResultSet records = null;
            System.out.println("Search Request");
            switch (flag) {
                case "title":
                    records = stat.executeQuery("SELECT * FROM songs WHERE (TITLE='" + song + "')");
                    return MakeArray(records);
                case "singer":
                    records = stat.executeQuery("SELECT * FROM songs WHERE (SINGER='" + song + "')");
                    return MakeArray(records);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    private ArrayList MakeArray(ResultSet records) {


        try {
            returned.clear();
            while (records.next()) {
                String title = records.getString("TITLE");
                String type = records.getString("TYPE");
                String singer = records.getString("SINGER");
                String duration = records.getString("DURATION");
                int stars = records.getInt("STARS");
                returned.add(title + "\t" + type + "\t" + singer + "\t" + duration + "\t" + stars);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;

    }


    public boolean Rate(String toRate, int stars) {
        try {
            //δεν ελέγχω αμα το τραγουδι που πληκτορλογει ο χρήστης υπάρχει μιας και απλα οταν το αναζητήσει για να δει
            //την βαθμολογία μετα δεν θα εμφανιστεί ποτέ παρά ένα μύνημα λάθους οτι δεν υπάρχει στο main table
            String message = "INSERT INTO rate (Title,stars) VALUES" +
                    " ('" + toRate + "','" + stars + "')";
            stat.executeUpdate(message);
            CalculateAverage(toRate);
            return true;


        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    private void CalculateAverage(String toRate) throws SQLException {
        ResultSet records = null;
        System.out.println("Calculating Average");
        records = stat.executeQuery("SELECT stars FROM rate WHERE (TITLE='" + toRate + "')");
        while (records.next())
            returned2.add(records.getInt("stars"));
        int avgstars = 0;
        for (int i = 0; i < returned2.size(); i++)
            avgstars = avgstars + returned2.get(i);
        avgstars = avgstars / returned2.size();
        stat.executeUpdate("UPDATE songs SET STARS='" + avgstars + "'WHERE TITLE='" + toRate + "'");

    }

    public ArrayList Rate_Search(int toSearch) {
        ResultSet records = null;
        try {
            records = stat.executeQuery("SELECT * FROM songs WHERE (STARS>='" + toSearch + "')");
            return MakeArray(records);
        } catch (SQLException e) {
            return null;
        }
    }
}

