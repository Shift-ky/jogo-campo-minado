package br.com.coder.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	 private final int linha;
	 private final int coluna;
	 
	 private boolean aberto = false;
	 private boolean minado = false;
	 private boolean marcado = false;
	 
	 private List<Campo> vizinhos = new ArrayList<>();
	 
	 Campo(int linha, int coluna){
		 this.linha = linha;
		this.coluna = coluna;
	 }
	 

}
