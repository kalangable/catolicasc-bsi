package org.catolicasc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;

import lombok.val;
import lombok.extern.java.Log;

@Log
public class MainLoop {

	public static void main( String[] args ) throws RemoteException {

		log.info( "Iniciando o RMI Server" );
		val folhaPagamentoService = new FolhaPagamentoImp();

		try {
			LocateRegistry.createRegistry( 1099 );
			Naming.bind( "///FolhaPagamentoService", folhaPagamentoService );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.log( Level.SEVERE, "Erro na publicao do RMI", e );
		}
		log.info( "Concluido" );

	}

}
