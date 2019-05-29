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
    JTextField singer = new JTextField();
    JTextField duration = new JTextField();
    JTextField stars = new JTextField();
    boolean check = false;
    Song look_op;


    public Insert_UI() throws RemoteException, NotBoundException, MalformedURLException {


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



        JButton submit = new JButton("Εισαγωγή");
        add(submit);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBInsert();
            }
        });

    }

    public void DBInsert() {
        try {
            look_op = (Song) Naming.lookup("//localhost/RMIServer");
            check = look_op.Insert(new _Song_toAdd(title.getText(), type.getText(), singer.getText(), duration.getText(),0));
            if (!check)
            {
                JOptionPane.showMessageDialog(null, "Το τραγούδι υπάρχει ήδη");
                return;
            }
            JOptionPane.showMessageDialog(null, "Το τραγουδι προστέθηκε με επιτυχία");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Υπήρξε πρόβλημα με την σύνδεση στη βάση");

        }
    }

}
