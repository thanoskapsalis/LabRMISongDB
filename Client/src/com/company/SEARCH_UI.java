package com.company;

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
    public static ArrayList result;
    Song look_op;

    public SEARCH_UI() throws RemoteException, NotBoundException, MalformedURLException {
        setSize(600, 300);
        setResizable(false);
        setLayout(new GridLayout(4, 1));
        add(toSearch);
        add(simple);
        add(singer);
        add(rate);


        simple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 TitleSearch();
            }
        });

        singer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingerSearch();
            }
        });
    }

    private void TitleSearch() {
        try {
            look_op = (Song) Naming.lookup("//localhost/RMIServer");
            System.out.println("naiainai" + toSearch.getText());
            result = look_op.Search(toSearch.getText(), "title");
            PrintResult();
            JOptionPane.showMessageDialog(null, result.get(0).toString());
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει τέτοιο τραγούδι");
        }

    }


    public void SingerSearch() {
        try {
            look_op = (Song) Naming.lookup("//localhost/RMIServer");
            result = look_op.Search(toSearch.getText(), "singer");
            PrintResult();
            Result_Window result_window = new Result_Window(result);
            result_window.setVisible(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει τέτοιο τραγούδι");
        }
    }

    public void PrintResult() {
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

}
