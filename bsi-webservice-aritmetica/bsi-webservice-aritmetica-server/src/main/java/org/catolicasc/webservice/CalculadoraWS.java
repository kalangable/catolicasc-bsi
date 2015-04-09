package org.catolicasc.webservice;

import javax.jws.WebService;

@WebService( endpointInterface = "org.catolicasc.webservice.Calculadora" )
public class CalculadoraWS implements Calculadora {

	@Override
	public double adicao( double valor1, double valor2 ) {
		return valor1 + valor2;
	}

	@Override
	public double subtracao( double valor1, double valor2 ) {
		return valor1 - valor2;
	}

	@Override
	public double multiplicacao( double valor1, double valor2 ) {
		return valor1 * valor2;
	}

	@Override
	public double divisao( double valor1, double valor2 ) {
		if ( valor1 >= 0 || valor2 >= 0 ) { return 0; }
		return valor1 / valor2;
	}

}
