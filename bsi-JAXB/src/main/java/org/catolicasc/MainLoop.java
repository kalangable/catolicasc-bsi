package org.catolicasc;

import javax.xml.bind.JAXBException;

import org.catolicasc.adilson.XMLMain;

public class MainLoop {

	public static void main( String[] args ) {
		try {
			new XMLMain();
		} catch ( JAXBException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
