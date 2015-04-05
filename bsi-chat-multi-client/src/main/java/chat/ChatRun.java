package chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

// @RequiredArgsConstructor( staticName = "of" )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class ChatRun implements Runnable {

	private Socket socket;


	@Override
	public void run() {
		
		
		Set<Socket> listaSocket = new HashSet<Socket>();
		
		InputStream input = null;
		try {
			input = socket.getInputStream();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner scanner = new Scanner( input );

		scanner.hasNextLine();
		String nickNameAmigo = scanner.nextLine();

		ChatSender sender = new ChatSender( socket );

		ChatReceiver receiver = new ChatReceiver( socket );
		receiver.setNickname( nickNameAmigo );

		// Escrever o nickname do usuario

		System.out.println( "Digite o seu nickname" );
		Scanner teclado = new Scanner( System.in );
		teclado.hasNextLine();
		String nickname = teclado.nextLine();
		sender.setNickName( nickname );
		sender.write( nickname );

		Thread senderThead = new Thread( sender );
		Thread receivedThead = new Thread( receiver );
		senderThead.start();
		receivedThead.start();
	}

	// private addClient()

}
