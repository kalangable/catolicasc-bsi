package org.catolicasc.copia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.logging.Level;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class CopiaCronometrada implements Callable<Long> {

	private String source;
	private String target;

	@Override
	public Long call() throws Exception {
		log.info( "Disparando o primeiro processo" );
		InputStream input = getInputStream( source );
		OutputStream output = getOutputStream( target );

		long initialTime = System.currentTimeMillis();
		copia( input, output );
		long finalTime = System.currentTimeMillis();
		return finalTime - initialTime;
	}

	private void copia( InputStream source, OutputStream target ) throws IOException {
		int controlador;
		byte[] conteudo = new byte[1024];
		while ( ( controlador = source.read() ) != -1 ) {
			source.read( conteudo, 0, conteudo.length );
			log.fine( "Gravando [" + new String( conteudo ) + "]" );
			target.write( conteudo );
		}
		source.close();
		target.close();

	}

	private InputStream getInputStream( String source ) {
		return getInputStream( new File( source ) );
	}

	private InputStream getInputStream( File source ) {
		return CopiaCronometrada.class.getResourceAsStream( target );

	}

	private OutputStream getOutputStream( String target ) {
		return getOutputStream( new File( target ) );
	}

	private OutputStream getOutputStream( File target ) {
		if ( !target.exists() ) {
			try {
				target.createNewFile();
			} catch ( IOException e ) {
				log.log( Level.SEVERE, "Nao foi possivel criar o arquivo : " + target.getAbsolutePath(), e );
			}
		}
		try {
			return new FileOutputStream( target );
		} catch ( FileNotFoundException e ) {
			log.log( Level.SEVERE, "Arquivo nao localizado : " + target.getAbsolutePath(), e );
		}
		return null;

	}

}
