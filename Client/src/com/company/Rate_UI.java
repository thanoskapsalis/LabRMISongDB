package com.company;

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
        setSize(600, 300);
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
                    look_op = (Song) Naming.lookup("//localhost/RMIServer");
                    if(look_op.Rate(torate.getText(),Integer.parseInt(mark.getText())))
                    {
                        JOptionPane.showMessageDialog(null,"Επιτυχής Βαθμολόγηση");
                        return;
                    }
                    JOptionPane.showMessageDialog(null,"Το τραγούδι δεν υπάρχει");

                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }

            }
        });



    }

}
