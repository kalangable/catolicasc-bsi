package org.catolicasc.adilson.aeroporto;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.catolicasc.adilson.bean.ListaAeroporto;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@Data
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class HttpHandlerListAeroporto implements HttpHandler {

	private ListaAeroporto listaAeroporto;
	protected MediaType mediaType;

	@Override
	public void handle( HttpExchange http ) throws IOException {
		http.sendResponseHeaders( 200, 0L );
		try {
			JAXBContext context = JAXBContext.newInstance( ListaAeroporto.class );
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

			if ( mediaType == MediaType.JSON )
			{

				marshaller.setProperty( "eclipselink.media-type", "application/json" );
				marshaller.setProperty( MarshallerProperties.JSON_INCLUDE_ROOT, true );
			}

			OutputStream outputStream = http.getResponseBody();
			marshaller.marshal( listaAeroporto, outputStream );
			outputStream.flush();
			outputStream.close();
		} catch ( JAXBException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
