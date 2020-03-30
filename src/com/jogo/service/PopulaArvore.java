package com.jogo.service;

import javax.swing.JOptionPane;

import com.jogo.factory.ArvoreBinaria;
import com.jogo.interfaces.ArvoreInterface;

public class PopulaArvore implements ArvoreInterface<ArvoreBinaria>{

	//Variável auxiliar para guardar o índice da árvore
	public static int aux = 1;
	
	public static ArvoreBinaria raiz;

	public ArvoreBinaria getArvore() {
		return raiz;
	}
	
	public void setArvore(ArvoreBinaria arvore) {
		raiz = arvore;
	}

	@Override
	public void inserirAnimal(ArvoreBinaria noArvore) {

		String animal = JOptionPane.showInputDialog(null, "Qual o animal que você pensou?");

		String caracteristica = JOptionPane.showInputDialog("Um(a) " + animal + "______ mas um(a) " + noArvore.valor + " não.");

		String auxiliar = noArvore.valor;
		noArvore.valor = caracteristica;
		noArvore.direita = new ArvoreBinaria(++aux, animal);
		noArvore.esquerda = new ArvoreBinaria(++aux, auxiliar);
	}

	@Override
	public void fazPerguntas(ArvoreBinaria noArvore) {
		
		int resposta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + noArvore.valor, "Confirme",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (resposta == 0) {
			if (noArvore.direita == null)
				JOptionPane.showMessageDialog(null, "Acertei!");
			// Faz a nova pergunta pra verificar sé realmente é o animal pensado
			else {
				fazPerguntas(noArvore.direita);
			}
			// Se resposta for não insere um novo animal caso o nó esteja vazio e realiza novamente as perguntas
		} else {
			if (noArvore.esquerda == null)
				inserirAnimal(noArvore);
			else {
				fazPerguntas(noArvore.esquerda);
			}
		}
	}

}
