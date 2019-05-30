package com.company;

//Θάννος Καψάλης 321/2015088

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Rate_UI extends JFrame {
    Song look_op;

    JTextField torate = new JTextField();
    JTextField mark = new JTextField();

    public Rate_UI() {
        super("Αξιολόγηση τραγουδιού");
        setSize(600, 200);
        setResizable(false);
        setLayout(new GridLayout(2, 2));
        add(torate);
        add(mark);
        JButton rate = new JButton("Rate");
        add(rate);


        rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Βαθμολογούμε το τραγούδι που θέλουμε σε περίπτωση που ο χρηστης επιλέξει λάθος βαθμό πετάμε το κατάλληλο exception
                    look_op = (Song) Naming.lookup("//localhost/RMIServer");
                    if (Integer.parseInt(mark.getText()) > 10 || Integer.parseInt(mark.getText()) < 0)
                        throw new NotBoundException();
                    if (look_op.Rate(torate.getText(), Integer.parseInt(mark.getText()))) {
                        JOptionPane.showMessageDialog(null, "Επιτυχής Βαθμολόγηση");
                        return;
                    }

                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, "Ο βαθμός πρέπει να είναι από 1 μέχρι και 10");
                    ex.printStackTrace();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Πρόβλημα σλυνδεσης με την βάση");
                }

            }
        });


    }

}
