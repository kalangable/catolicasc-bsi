package org.catolicasc;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

import lombok.extern.java.Log;

import org.catolicasc.webservice.CalculadoraWS;

@Log
public class MainLoop {

	public static void main( String[] args ) throws MalformedURLException {

		log.info( "Criando WS: http://localhost:8080/WS/Calculadora?wsdl" );
		Endpoint.publish( "http://localhost:8080/WS/Calculadora", new CalculadoraWS() );
	}

}
