package com.company;

import javax.print.DocFlavor;
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
                    System.out.println("title");
                    records = stat.executeQuery("SELECT * FROM songs WHERE (TITLE='" + song + "')");

                    return MakeArray(records);
                case "singer":
                    records = stat.executeQuery("SELECT * FROM songs WHERE (SINGER='" +song + "')");
                    return MakeArray(records);
            }


        }
        catch (Exception e){
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
                returned.add(title + "\t" +type+"\t"+ singer + "\t" + duration + "\t" + stars);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;

    }

    public void PrintArray()
    {
        for (int i=0; i<returned.size(); i++){
            System.out.println(returned.get(i));
        }
    }
}

