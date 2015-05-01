package org.catolicasc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Som extends Remote {
	public void ligarSom( String nomeCliente ) throws RemoteException;

	public void desligarSom( String nomeCliente ) throws RemoteException;
}
