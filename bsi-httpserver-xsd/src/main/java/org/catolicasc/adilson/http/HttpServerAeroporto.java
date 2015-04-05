package org.catolicasc.adilson.http;

import java.util.List;
import java.util.concurrent.ExecutorService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.val;
import lombok.extern.java.Log;

import org.catolicasc.adilson.aeroporto.HttpHandlerAeroporto;
import org.catolicasc.adilson.aeroporto.HttpHandlerListAeroporto;
import org.catolicasc.adilson.aeroporto.MediaType;
import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.ListaAeroporto;
import org.catolicasc.adilson.config.Configuration;
import org.catolicasc.adilson.config.HttpServerAeroportoConfiguration;

import com.sun.net.httpserver.HttpServer;

@Log
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class HttpServerAeroporto {

	private HttpServer server;
	private ExecutorService pool;

	public void execute() {

		List<Aeroporto> listaAero = new HttpServerAeroportoConfiguration( Configuration.loadConfiguration() ).listaAeroporto();
		server.createContext( "/" + MediaType.XML + "/", new HttpHandlerListAeroporto( new ListaAeroporto( listaAero ), MediaType.XML ) );
		server.createContext( "/" + MediaType.JSON + "/", new HttpHandlerListAeroporto( new ListaAeroporto( listaAero ), MediaType.JSON ) );

		for ( Aeroporto aeroporto : listaAero ) {
			createContextApp( aeroporto );
		}
		server.setExecutor( pool );
		server.start();
	}

	private void createContextApp( Aeroporto aeroporto, MediaType typeApp ) {
		val nomeAeroporto = "/" + typeApp + "/" + aeroporto.getNome().toLowerCase().replace( ' ', '-' );
		val cidadeAeroporto = "/" + typeApp + "/" + aeroporto.getCidade().getCidade().toLowerCase().replace( ' ', '-' );
		log.info( "Criando o contexto de nome de AeroPorto " + nomeAeroporto );
		server.createContext( nomeAeroporto, new HttpHandlerAeroporto( aeroporto, typeApp ) );
		log.info( "Criando o contexto de nome da Cidade " + cidadeAeroporto );
		server.createContext( cidadeAeroporto, new HttpHandlerAeroporto( aeroporto, typeApp ) );
	}

	private void createContextApp( Aeroporto aeroporto ) {
		createContextApp( aeroporto, MediaType.XML );
		createContextApp( aeroporto, MediaType.JSON );
	}
}
