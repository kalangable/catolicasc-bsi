package org.catolicasc.adilson.aeroporto;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import org.catolicasc.adilson.bean.Aeroporto;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@Log
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@Data
@NoArgsConstructor
public class HttpHandlerAeroporto implements HttpHandler {

	protected Aeroporto aeroporto;
	protected MediaType mediaType;

	@Override
	public void handle( HttpExchange http ) throws IOException {
		log.fine( "Criando o Handler " );
		http.sendResponseHeaders( 200, 0L );
		OutputStream outputStream = http.getResponseBody();
		JAXBContext context = null;
		Marshaller marshaller = null;
		try {
			context = JAXBContext.newInstance( Aeroporto.class );
			marshaller = context.createMarshaller();
			this.outputMarshaller( marshaller, outputStream );
		} catch ( JAXBException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		outputStream.flush();
		outputStream.close();

	}

	private void outputMarshaller( Marshaller marshaller, OutputStream output ) throws JAXBException {

		marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		if ( mediaType == MediaType.JSON )
		{

			marshaller.setProperty( "eclipselink.media-type", "application/json" );
			marshaller.setProperty( "eclipselink.json.include-root", true );
		}
		// OutputStream outputStream = http.getResponseBody();
		marshaller.marshal( aeroporto, output );

	}
}
