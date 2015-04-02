package org.catolicasc.adilson.aeroporto;

import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.Cidade;

public class HttpHandlerAfonsoPena extends HttpHandlerAeroporto {

	public HttpHandlerAfonsoPena() {
		super( new Aeroporto( "Afonso Pena", true, new Cidade( "Curitiba", "PR", "Brasil" ) ) );
	}

}
