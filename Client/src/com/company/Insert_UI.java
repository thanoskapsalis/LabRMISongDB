package com.company;

import javax.swing.*;
import java.awt.*;

public class Insert_UI extends JFrame {

    JTextField title = new JTextField();
    JTextField type = new JTextField();
    JTextField singer   = new JTextField();
    JTextField duration   = new JTextField();
    JTextField stars   = new JTextField();



    public Insert_UI() {
        super("Νέo Τραγούδι");
        setSize(600, 300);
        setResizable(false);
        setLayout(new GridLayout(6, 2));

        JLabel titlel = new JLabel("Τίτλος");
        add(titlel);
        add(title);

        JLabel typel = new JLabel("Τύπος");
        add(typel);
        add(type);

        JLabel singerl = new JLabel("Τραγουδιστής");
        add(singerl);
        add(singer);

        JLabel durationl = new JLabel("Διάρκεια(mm:ss)");
        add(durationl);
        add(duration);

        JLabel starsl = new JLabel("Αστέρια (1-5)");
        add(starsl);
        add(stars);

        JButton submit = new JButton("Εισαγωγή");
        add(submit);

    }

}
