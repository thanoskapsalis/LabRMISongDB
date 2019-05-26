package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class RMIHandler extends UnicastRemoteObject implements Song {
    Controller controller;
    boolean check = false;

    public RMIHandler() throws RemoteException {
        super();
        System.out.println("RMI Booted Successfully");
        controller = new Controller();
    }


    @Override
    public boolean Insert(_Song_toAdd song) throws RemoteException{
        return controller.Insert_Song(song);
    }

    @Override
    public ArrayList Search(String song, String flag) throws RemoteException {
        System.out.println("Searching Request");
        return controller.Search(song, flag);
    }

}
