package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIHandler extends UnicastRemoteObject implements Song {

    public RMIHandler() throws RemoteException
    {
        super();
        System.out.println("RMI Booted Successfully");
    }

    @Override
    public void Insert(String title, String type, String singer, String duration, String stars) {
        _Song_toAdd song = new _Song_toAdd(title,type,singer,duration,stars);
    }
}
