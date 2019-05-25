package com.company;

import java.rmi.Naming;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {

        RMIHandler handler;

        //Εκίνηση RMI

        try {

            handler = new RMIHandler();

            System.out.println("ServerBooted");

            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);

            Naming.rebind("//localhost/RMIServer", handler);


        } catch (Exception e) {

            System.out.println(e);


        }
    }
}
