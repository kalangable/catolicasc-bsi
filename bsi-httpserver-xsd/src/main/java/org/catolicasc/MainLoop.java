package org.catolicasc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.catolicasc.adilson.http.HttpServerVoe;

import com.sun.net.httpserver.HttpServer;

public class MainLoop {

	public static void main( String[] args ) throws IOException {

		// Config conf = ConfigFactory.load( "conf/aeroporto" );
		//
		// val confList = conf.getConfigList( "lista.aeroportos" );
		//
		// for ( Config config : confList ) {
		// // System.out.println(conf.);
		// System.out.println( config.getString( "nome" ) );
		// System.out.println( config.getString( "cidade.nome" ) );
		// }
		// arg0 )( "aeroporto.aeroportos" ).;

		// ConfigObject

		ExecutorService pool = Executors.newFixedThreadPool( 100 );

		InetSocketAddress inetAddress = new InetSocketAddress( "localhost",
				2000 );

		new HttpServerVoe( HttpServer.create( inetAddress, 10 ), pool ).execute();

	}

}
