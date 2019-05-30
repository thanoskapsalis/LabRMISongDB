package com.company;

//Θάνος Καψάλης 321/2015088

//Εμφάνιση αποτελεσμάτων αναζήτησης

import javax.swing.*;
import java.util.ArrayList;

public class Result_Window extends JFrame {

    public Result_Window(ArrayList<String> result) {
        super("Αποτελέσματα Αναζήτησης");
        setSize(600, 300);
        setResizable(false);
        JTextArea textArea = new JTextArea();
        add(textArea);
        textArea.setEditable(false);
        textArea.setText("Title" + "\t" + "Type" + "\t" + "Singer" + "\t" + "Duration" + "\t" + "Stars\n");
        for (int i = 0; i < result.size(); i++)
            textArea.append(result.get(i)+"\n");
    }
}
