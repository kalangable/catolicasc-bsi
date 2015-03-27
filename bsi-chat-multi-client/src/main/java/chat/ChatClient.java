package chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main( String[] args ) throws IOException {
		Socket socket = new Socket( "127.0.01", 2020 );

		Scanner teclado = new Scanner( System.in );
		System.out.println( "Digite o seu nickname" );
		String nickname = teclado.nextLine();

		// ChatSender sender = new ChatSender( socket );
		//
		ChatReceiver receiver = new ChatReceiver( socket );

		ChatSender sender = new ChatSender( socket );

		sender.setNickName( nickname );
		sender.write( nickname );

		InputStream input = socket.getInputStream();

		Scanner scanner = new Scanner( input );

		scanner.hasNextLine();
		String nickNameAmigo = scanner.nextLine();

		receiver.setNickname( nickNameAmigo );
		Thread senderThead = new Thread( sender );
		Thread receivedThead = new Thread( receiver );
		senderThead.start();
		receivedThead.start();

	}

}
