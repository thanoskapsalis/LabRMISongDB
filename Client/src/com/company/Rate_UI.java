package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rate_UI extends JFrame {

    JTextField torate = new JTextField();

    public Rate_UI() {
        super("Αξιολόγηση τραγουδιού");
        setSize(600, 300);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        add(torate);
        JButton rate = new JButton("Rate");



    }

}
