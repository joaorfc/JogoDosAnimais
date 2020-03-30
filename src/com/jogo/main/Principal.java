package com.jogo.main;

import javax.swing.JOptionPane;

import com.jogo.factory.ArvoreBinaria;
import com.jogo.service.PopulaArvore;

public class Principal {

	//Variável auxiliar para guardar o índice da árvore
	public static int aux = 1;

	public static void main(String[] args) {
		
			PopulaArvore arvore = new PopulaArvore();
			JOptionPane.showMessageDialog(null, "Vamos começar?");
			JOptionPane.showMessageDialog(null, "Pense em um Animal");
			
			// Construindo árvore binária
			if (arvore.getArvore() == null) {
				arvore.setArvore(new ArvoreBinaria(aux, "vive na agua"));
				arvore.getArvore().esquerda = new ArvoreBinaria(++aux, "Macaco");
				arvore.getArvore().direita = new ArvoreBinaria(++aux, "Tubarao");
			}
			int sair = 1;
			// Permanece no laço enquanto sair = 1.
			while(sair == 1) {
			
				int resposta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + arvore.getArvore().valor, "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == 0) {
					arvore.fazPerguntas(arvore.getArvore().direita);
				} else {
					arvore.fazPerguntas(arvore.getArvore().esquerda);
				}
				//Sair da aplicação
				if (resposta == JOptionPane.CLOSED_OPTION) {
					sair = 0;
				}
			}
	}

}
