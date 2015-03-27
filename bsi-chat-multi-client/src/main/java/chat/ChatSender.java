package chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatSender implements Runnable {

	private Socket socket;

	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName( String nickName ) {
		this.nickName = nickName;
	}

	public ChatSender( Socket socket ) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner teclado = new Scanner( System.in );

		while ( teclado.hasNext() ) {
			String mensagem = teclado.nextLine();

			if ( mensagem.equals( "/exit" ) ) {
				System.out.println( "voce saiu da conversa." );
				teclado.close();
				break;
			} else {
				this.write( mensagem );
			}
		}

	}

	public void write( String mensagem ) {
		PrintStream writer = null;

		try {
			OutputStream outputStream = socket.getOutputStream();
			writer = new PrintStream( outputStream );
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println( nickName + " = " + mensagem );

		writer.println( mensagem );
		writer.flush();
	}

}
