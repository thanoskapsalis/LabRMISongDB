package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_UI extends JFrame {


    public Client_UI(){
        super("Αρχική Σελίδα");
        setSize(600, 200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Επιλέξτε μια απο τις παρακάτω επιλογές");
        add(label);

        JButton insert = new JButton("Εισαγωγή");
        add(insert);


        JButton search = new JButton("Αναζήτηση");
        add(search);


        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insert_UI insert_ui = new Insert_UI();
                insert_ui.setVisible(true);
            }
        });

    }
}
