package org.catolicasc.adilson.aeroporto;

import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.Cidade;

public class HttpHandlerGuarulhos extends HttpHandlerAeroporto {

	public HttpHandlerGuarulhos() {
		super( new Aeroporto( "Guarulhos", false, new Cidade( "Sao Paulo", "SP", "Brasil" ) ) );
	}
}
