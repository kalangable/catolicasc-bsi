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
		InputStream input = getInputStream();
		OutputStream output = getOutputStream();

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
			log.finest( "Gravando [" + new String( conteudo ) + "]" );
			target.write( conteudo );
		}
		source.close();
		target.close();

	}

	private InputStream getInputStream() {

		File fileSource = new File( this.source );

		if ( !fileSource.exists() ) {
			ClassLoader cl = getClass().getClassLoader();
			return cl.getResourceAsStream( source );
		}

		try {
			return new FileInputStream( fileSource );
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private OutputStream getOutputStream() {
		File targetFile = new File( this.target );
		int controle = 0;
		while ( !( targetFile.exists() ) ) {
			try {
				targetFile.createNewFile();
			} catch ( IOException e1 ) {
				try {
					targetFile.createTempFile( "copia_" + controle, "txt" );
				} catch ( IOException e ) {
					log.log( Level.SEVERE, "QUE ERRO 2" + targetFile.getAbsolutePath(), e );
					controle++;
				}
			}
		}
		try {
			return new FileOutputStream( targetFile );
		} catch ( FileNotFoundException e ) {
			log.log( Level.SEVERE, "Arquivo nao localizado : " + targetFile.getAbsolutePath(), e );
		}
		return null;

	}

}
