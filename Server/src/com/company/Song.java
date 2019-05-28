package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Song extends Remote {

    public boolean Insert(_Song_toAdd song) throws RemoteException;
    public ArrayList Search(String toSearch, String flag) throws RemoteException;
    public boolean Rate(String toRate,int stars) throws RemoteException;

}
