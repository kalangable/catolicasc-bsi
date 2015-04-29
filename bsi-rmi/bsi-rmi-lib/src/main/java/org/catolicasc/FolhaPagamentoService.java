package org.catolicasc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FolhaPagamentoService extends Remote {

	double calculoHorista( Funcionario funcionario ) throws RemoteException;
}
