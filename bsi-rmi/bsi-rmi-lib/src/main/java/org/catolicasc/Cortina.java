package org.catolicasc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cortina extends Remote {
	public void abrirCortina( String nomeCliente ) throws RemoteException;

	public void fecharCortina( String nomeCliente ) throws RemoteException;
}
