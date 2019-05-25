package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Song extends Remote {
    public  boolean Insert(_Song_toAdd song) throws RemoteException;
    public ArrayList Search(_Song_toAdd song, String flag) throws RemoteException;

}
