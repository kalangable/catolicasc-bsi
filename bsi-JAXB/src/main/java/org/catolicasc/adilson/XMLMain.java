package org.catolicasc.adilson;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLMain {

	public XMLMain() throws JAXBException{

		Expense expense = new Expense();

		Item item = new Item();
		item.setAmount( new BigDecimal( 15 ) );
		item.setItemName( "Qualquer" );
		item.setPurchasedOn( "Novo valor" );

		Item item2 = new Item();
		item2.setAmount( new BigDecimal( 150 ) );
		item2.setItemName( "Secador" );
		item2.setPurchasedOn( "Compre" );

		User user = new User();
		user.setUserName( "Adilson" );

		ItemList itemList = new ItemList();

		itemList.item = new ArrayList<Item>();

		itemList.item.add( item );
		itemList.item.add( item2 );

		expense.setItems( itemList );
		expense.setUser( user );

		ObjectFactory factory = new ObjectFactory();

		JAXBContext context = JAXBContext.newInstance( Expense.class );

		JAXBElement<Expense> element = factory.createExpenseReport( expense );

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		marshaller.marshal( element, System.out );

	}

}
