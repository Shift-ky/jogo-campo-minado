package br.com.coder.cm;

import br.com.coder.cm.modelo.Tabuleiro;
import br.com.coder.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		
		new TabuleiroConsole(tabuleiro);
	}

}
