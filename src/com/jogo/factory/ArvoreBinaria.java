package com.jogo.factory;

public class ArvoreBinaria {

	public int elemento;
	public ArvoreBinaria esquerda;
	public ArvoreBinaria direita;
	public String valor;

	//Método que popula árvore
	public ArvoreBinaria(int elemento, String valor) {
		System.out.println(elemento + " - " + valor);
		this.elemento = elemento;
		this.valor = valor;
	}

}
