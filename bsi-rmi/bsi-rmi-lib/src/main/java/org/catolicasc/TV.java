package org.catolicasc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TV extends Remote {
	public void ligarTV( String nomeCliente ) throws RemoteException;

	public void desligarTV( String nomeCliente ) throws RemoteException;
}
