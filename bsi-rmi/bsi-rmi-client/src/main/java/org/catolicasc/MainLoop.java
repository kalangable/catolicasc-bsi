package org.catolicasc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lombok.val;
import lombok.extern.java.Log;

@Log
public class MainLoop {

	public static final String LOOKUP = "//localhost/FolhaPagamentoService";

	public static void main( String[] args ) throws MalformedURLException, RemoteException, NotBoundException {
		log.info( "Inciando o Cliente" );
		val funcionario = new Funcionario();
		funcionario.setNome( "Adilson Krasovski" );
		funcionario.setQtdeHoras( 200 );
		funcionario.setValorHora( 11 );

		FolhaPagamentoService folhaPagamentoService;
		folhaPagamentoService = (FolhaPagamentoService)Naming.lookup( LOOKUP );
		log.info( "Calculo" );
		System.out.println( folhaPagamentoService.calculoHorista( funcionario ) );

	}
}
