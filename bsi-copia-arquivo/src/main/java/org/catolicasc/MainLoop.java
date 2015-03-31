package org.catolicasc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.catolicasc.copia.CopiaCronometrada;

public class MainLoop {

	public static void main( String[] args ) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool( 3 );

		List<Future<Long>> listFuture = new ArrayList<Future<Long>>();

		Callable<Long> cc1 = new CopiaCronometrada( "Lorem3.txt", "C:\\tmp\\Lorem3.txt" );
		Future fut = service.submit( cc1 );
		listFuture.add( fut );
		// future.add( service.submit( new CopiaCronometrada( "Lorem1.txt",
		// "C:\\tmp\\Lorem1.txt" ) ) );
		// future.add( service.submit( new CopiaCronometrada( "Lorem2.txt",
		// "C:\\tmp\\Lorem2.txt" ) ) );

		for ( Future<Long> future2 : listFuture ) {
			System.out.println( "Tempo para a execução da copia = " + future2.get() );
		}

	}

}
