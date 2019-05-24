package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Song extends Remote {

    public void Insert(String title, String type, String singer, String duration, String stars) throws RemoteException;
}
