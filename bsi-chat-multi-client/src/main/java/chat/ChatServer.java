package chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main( String[] args ) throws IOException {
		ServerSocket server = new ServerSocket( 2020 );
		// System.err.println( "Aguardando Conexao" );
		Socket cliente = server.accept();

		// System.err.println( "Criando inputstream" );
		InputStream input = cliente.getInputStream();

		// System.err.println( "Criando o scanner" );
		Scanner scanner = new Scanner( input );

		// System.err.println( "Aguardando o scanner" );
		scanner.hasNextLine();
		// System.err.println( "Capturando o nome" );
		String nickNameAmigo = scanner.nextLine();
		// System.err.println( "Amigo " + nickNameAmigo );

		ChatSender sender = new ChatSender( cliente );

		ChatReceiver receiver = new ChatReceiver( cliente );
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

}
