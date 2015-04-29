package org.catolicasc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lombok.extern.java.Log;
@Log
public class FolhaPagamentoImp extends UnicastRemoteObject implements FolhaPagamentoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 554394309551747649L;

	protected FolhaPagamentoImp() throws RemoteException {
		super();
	}

	@Override
	public double calculoHorista( Funcionario funcionario ) throws RemoteException {
		log.info( "Calculando o Salario do " + funcionario );
		return 1.0 * ( funcionario.getValorHora() * funcionario.getQtdeHoras() );
	}

}
