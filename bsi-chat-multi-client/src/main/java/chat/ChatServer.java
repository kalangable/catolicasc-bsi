package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	public static void main( String[] args ) throws IOException {

		ServerSocket server = new ServerSocket( 2020 );

		ExecutorService pool = Executors.newCachedThreadPool();

		while ( true ) {
			pool.execute( new ChatRun( server.accept() ) );

		}

	}

}
