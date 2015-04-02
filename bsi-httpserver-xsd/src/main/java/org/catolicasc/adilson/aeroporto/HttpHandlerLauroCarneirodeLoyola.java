package org.catolicasc.adilson.aeroporto;

import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.Cidade;

public class HttpHandlerLauroCarneirodeLoyola extends HttpHandlerAeroporto {

	public HttpHandlerLauroCarneirodeLoyola() {
		super( new Aeroporto( "Lauro Carneiro de Loyola", false, new Cidade( "Joinville", "SC", "Brasil" ) ) );
	}

}
