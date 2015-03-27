package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatReceiver implements Runnable {

	private Socket socket;

	private String nickname;

	public ChatReceiver( Socket socket ) {
		this.socket = socket;
	}

	@Override
	public void run() {
		String mensagem = "";
		Scanner entrada = null;
		try {
			entrada = new Scanner( socket.getInputStream() );
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while ( entrada.hasNextLine() ) {

			mensagem = entrada.nextLine();

			System.out.println( this.nickname + ": " + mensagem );

			if ( mensagem.equals( "/exit" ) ) {
				System.out.println( this.nickname + " saiu da conversa." );
				entrada.close();
				break;
			}
		}

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}

}
