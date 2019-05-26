package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SEARCH_UI extends JFrame {
    JTextField toSearch = new JTextField();
    JButton simple = new JButton("Αναζήτηση Τραγουδιού");
    JButton singer = new JButton("Αναζήτηση Τραγουδιών του Καλλιτέχνη");
    JButton  rate = new JButton("Αναζήτηση και βαθμολόγηση τραγουδιού");
    public static ArrayList result;
    Song look_op;
    public SEARCH_UI()
    {
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
                try {
                    System.out.println("naiainai"+toSearch.getText());
                      result =look_op.Search(toSearch.getText(),"title");
                    if(result==null)
                        JOptionPane.showMessageDialog(null,"Δεν υπάρχει τραγούδι");
                    else
                    {
                        JOptionPane.showMessageDialog(null,result.get(0).toString());
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });

    }
}
