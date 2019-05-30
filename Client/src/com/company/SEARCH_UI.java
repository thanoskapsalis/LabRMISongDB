package com.company;

//Θάνος Καψάλης 321/2015088



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SEARCH_UI extends JFrame {
    JTextField toSearch = new JTextField();
    JButton simple = new JButton("Αναζήτηση Τραγουδιού");
    JButton singer = new JButton("Αναζήτηση Τραγουδιών του Καλλιτέχνη");
    JButton rate = new JButton("Αναζήτηση και βαθμολόγηση τραγουδιού");
    JButton threshold = new JButton("Αναζήτηση Τραγουδιών μεγαλύτερης της συγκεκριμένης βαθμολογίας");

    public static ArrayList result;
    Song look_op;

    public SEARCH_UI() throws RemoteException, NotBoundException, MalformedURLException {
        setSize(600, 600);
        setResizable(false);
        setLayout(new GridLayout(5, 1));
        add(toSearch);
        add(simple);
        add(singer);
        add(rate);
        add(threshold);


        simple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingerSearch("title");
            }
        });

        singer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingerSearch("singer");
            }
        });

        rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rate_UI rate_ui = new Rate_UI();
                rate_ui.setVisible(true);
            }
        });

        threshold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rate_Searchs();
            }
        });
    }

    private void Rate_Searchs() {
        try {
            look_op = (Song) Naming.lookup("//localhost/RMIServer");
            result = look_op.Rate_Search(Integer.parseInt(toSearch.getText()));
            Result_Window result_window = new Result_Window(result);
            result_window.setVisible(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει τέτοιο τραγούδι");
        }
    }


    public void SingerSearch(String flag) {
        try {
            look_op = (Song) Naming.lookup("//localhost/RMIServer");
            result = look_op.Search(toSearch.getText(), flag);
            Result_Window result_window = new Result_Window(result);
            result_window.setVisible(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει τέτοιο τραγούδι");
        }
    }



}
