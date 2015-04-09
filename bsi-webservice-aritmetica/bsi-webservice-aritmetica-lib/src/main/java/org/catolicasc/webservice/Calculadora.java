package org.catolicasc.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding( style = Style.RPC )
public interface Calculadora {

	@WebMethod
	double adicao( double valor1, double valor2 );

	@WebMethod
	double subtracao( double valor1, double valor2 );

	@WebMethod
	double multiplicacao( double valor1, double valor2 );

	@WebMethod
	double divisao( double valor1, double valor2 );

}
