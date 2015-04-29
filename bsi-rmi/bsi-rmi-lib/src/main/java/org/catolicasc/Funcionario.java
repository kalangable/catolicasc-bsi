package org.catolicasc;

import java.io.Serializable;

import lombok.Data;

@Data
public class Funcionario implements Serializable {
	private String nome;
	private double valorHora;
	private int qtdeHoras;

}
