package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Song extends Remote {

    public boolean Insert(_Song_toAdd song) throws RemoteException;

}
