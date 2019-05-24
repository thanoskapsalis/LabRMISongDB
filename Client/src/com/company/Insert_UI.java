package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Song look_op = (Song) Naming.lookup("//localhost/RMIServer");
                    look_op.Insert(title.getText(),type.getText(),singer.getText(),duration.getText(),stars.getText());
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
