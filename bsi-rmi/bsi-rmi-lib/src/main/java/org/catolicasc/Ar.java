package org.catolicasc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ar extends Remote {
	public void ligarAr(String nomeCliente) throws RemoteException;

	public void desligarAr(String nomeCliente) throws RemoteException;
}
