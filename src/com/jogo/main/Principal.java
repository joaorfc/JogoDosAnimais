package com.jogo.main;

import javax.swing.JOptionPane;

import com.jogo.factory.ArvoreBinaria;
import com.jogo.service.PopulaArvore;

public class Principal {

	//Vari�vel auxiliar para guardar o �ndice da �rvore
	public static int aux = 1;

	public static void main(String[] args) {
		
			PopulaArvore arvore = new PopulaArvore();
			JOptionPane.showMessageDialog(null, "Vamos come�ar?");
			JOptionPane.showMessageDialog(null, "Pense em um Animal");
			
			// Construindo �rvore bin�ria
			if (arvore.getArvore() == null) {
				arvore.setArvore(new ArvoreBinaria(aux, "vive na agua"));
				arvore.getArvore().esquerda = new ArvoreBinaria(++aux, "Macaco");
				arvore.getArvore().direita = new ArvoreBinaria(++aux, "Tubarao");
			}
			int sair = 1;
			// Permanece no la�o enquanto sair = 1.
			while(sair == 1) {
			
				int resposta = JOptionPane.showConfirmDialog(null, "O animal que voc� pensou " + arvore.getArvore().valor, "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == 0) {
					arvore.fazPerguntas(arvore.getArvore().direita);
				} else {
					arvore.fazPerguntas(arvore.getArvore().esquerda);
				}
				//Sair da aplica��o
				if (resposta == JOptionPane.CLOSED_OPTION) {
					sair = 0;
				}
			}
	}

}
