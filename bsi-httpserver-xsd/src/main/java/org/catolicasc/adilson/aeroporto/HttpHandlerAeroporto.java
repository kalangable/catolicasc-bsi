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

import org.catolicasc.adilson.bean.Aeroporto;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@AllArgsConstructor( access = AccessLevel.PUBLIC )
@Data
@NoArgsConstructor
public abstract class HttpHandlerAeroporto implements HttpHandler {

	protected Aeroporto aeroporto;

	public void handle( HttpExchange http ) throws IOException {

		http.sendResponseHeaders( 200, 0L );
		try {
			JAXBContext context = JAXBContext.newInstance( Aeroporto.class );
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			OutputStream outputStream = http.getResponseBody();
			marshaller.marshal( aeroporto, outputStream );
			outputStream.flush();
			outputStream.close();
		} catch ( JAXBException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
