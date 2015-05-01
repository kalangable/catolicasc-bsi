


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lombok.extern.java.Log;

@Log
public class MainLoop {

	public static final String SERVER_RMI = "//JOIC04PC01";

	public static void main( String[] args ) throws MalformedURLException, RemoteException, NotBoundException {

		TV tv = (TV)Naming.lookup( SERVER_RMI + "/TVServer" );
		Som som = (Som)Naming.lookup( SERVER_RMI + "/SomServer" );
		Cortina cortina = (Cortina)Naming.lookup( SERVER_RMI + "/CortinaServer" );
		Ar ar = (Ar)Naming.lookup( SERVER_RMI + "/ArServer" );
		ClienteGui gui = new ClienteGui( tv, som, ar, cortina, "Adilson" );

		gui.setVisible( true );
		

	}
}
