package org.catolicasc.adilson.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.experimental.Accessors;

import org.catolicasc.adilson.bean.Aeroporto;
import org.catolicasc.adilson.bean.Cidade;

import com.typesafe.config.Config;

@Getter
@Accessors( fluent = true )
@RequiredArgsConstructor
public class HttpServerAeroportoConfiguration {

	final Config config;

	public List<Aeroporto> listaAeroporto() {
		val listaAero = config().getConfigList( "lista.aeroportos" );
		ArrayList<Aeroporto> listaRetorno = new ArrayList<Aeroporto>();
		for ( Config config : listaAero ) {
			Aeroporto aeroporto = new Aeroporto();
			aeroporto.setInternacional( config.getBoolean( "internacional" ) );
			aeroporto.setNome( config.getString( "nome" ) );
			Cidade cidade = new Cidade();
			cidade.setCidade( config.getString( "cidade.nome" ) );
			cidade.setUf( config.getString( "cidade.uf" ) );
			cidade.setPais( config.getString( "cidade.pais" ) );
			aeroporto.setCidade( cidade );

			listaRetorno.add( aeroporto );
		}

		return listaRetorno;

	}

}
