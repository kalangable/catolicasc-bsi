package org.catolicasc.adilson.http;

import java.io.IOException;
import java.io.OutputStream;

import lombok.extern.java.Log;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@Log
public class HttpHandlerXSD implements HttpHandler {

	@Override
	public void handle( HttpExchange http ) throws IOException {
		String resposta = "Alou mundo!";
		http.sendResponseHeaders( 200, resposta.length() );
		OutputStream out = http.getResponseBody();
		out.write( resposta.getBytes() );
		out.flush();
		out.close();

	}

}
