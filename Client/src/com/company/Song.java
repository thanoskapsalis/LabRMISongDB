package com.company;

//Θάνος Καψάλης 321/2015088

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Song extends Remote {
    public  boolean Insert(_Song_toAdd song) throws RemoteException;
    public ArrayList Search(String song, String flag) throws RemoteException;
    public boolean Rate(String toRate,int stars) throws RemoteException;
    public ArrayList Rate_Search(int toSearch) throws RemoteException;

}
