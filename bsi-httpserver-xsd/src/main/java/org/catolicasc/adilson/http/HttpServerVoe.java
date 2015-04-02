package org.catolicasc.adilson.http;

import java.util.concurrent.ExecutorService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.catolicasc.adilson.aeroporto.HttpHandlerAfonsoPena;
import org.catolicasc.adilson.aeroporto.HttpHandlerConconhas;
import org.catolicasc.adilson.aeroporto.HttpHandlerGuarulhos;
import org.catolicasc.adilson.aeroporto.HttpHandlerLauroCarneirodeLoyola;

import com.sun.net.httpserver.HttpServer;

@AllArgsConstructor( access = AccessLevel.PUBLIC )
@Getter
public class HttpServerVoe {

	private HttpServer server;
	private ExecutorService pool;

	public void execute() {
		server.createContext( "/guarulhos", new HttpHandlerGuarulhos() );
		server.createContext( "/sao-paulo", new HttpHandlerGuarulhos() );
		server.createContext( "/lauro-carneiro-de-loyola", new HttpHandlerLauroCarneirodeLoyola() );
		server.createContext( "/joinville", new HttpHandlerLauroCarneirodeLoyola() );
		server.createContext( "/congonhas", new HttpHandlerConconhas() );
		server.createContext( "/rio-de-janeiro", new HttpHandlerConconhas() );
		server.createContext( "/afonso-pena", new HttpHandlerAfonsoPena() );

		server.createContext( "/", new HttpHandlerGuarulhos() );
		server.setExecutor( pool );
		server.start();
	}

}
