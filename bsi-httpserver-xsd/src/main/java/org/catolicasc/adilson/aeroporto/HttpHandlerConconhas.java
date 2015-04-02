package org.catolicasc.adilson.aeroporto;

import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.Cidade;

public class HttpHandlerConconhas extends HttpHandlerAeroporto {

	public HttpHandlerConconhas() {
		super( new Aeroporto( "Conconhas", true, new Cidade( "Rio de Janeiro", "RJ", "Brasil" ) ) );
		
		
	}

}
