package org.catolicasc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import lombok.val;
import lombok.extern.java.Log;

import org.catolicasc.adilson.http.HttpServerAeroporto;

import com.sun.net.httpserver.HttpServer;

@Log
public class MainLoop {

	public static void main( String[] args ) throws IOException {

		val pool = Executors.newFixedThreadPool( 100 );

		val inetAddress = new InetSocketAddress( "localhost", 2000 );
		log.fine( "Iniciando a aplicacao" );
		val httpServer = HttpServer.create( inetAddress, 10 );
		val http = new HttpServerAeroporto( httpServer, pool );
		http.execute();

	}

}
