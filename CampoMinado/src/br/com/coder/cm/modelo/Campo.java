package br.com.coder.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.coder.cm.execesao.explosaoExcetion;

public class Campo {
	
	 private final int linha;
	 private final int coluna;
	 
	 private boolean aberto = false;
	 private boolean minado = false;
	 private boolean marcado = false;
	 
	 private List<Campo> vizinhos = new ArrayList<>();
	 
	 public Campo(int linha, int coluna){
		 this.linha = linha;
		this.coluna = coluna;
	 }
	 
	 public boolean adicionarVizinho(Campo vizinho){ /*Início do método*/
		 boolean linhaDiferente = linha != vizinho.linha;
		 boolean colunaDiferente = coluna != vizinho.coluna;
		 boolean diagonal = linhaDiferente && colunaDiferente;
		 
		 int deltaLinha = Math.abs(linha - vizinho.linha);
		 int deltaColuna = Math.abs(coluna - vizinho.coluna);
		 int deltaGeral = deltaColuna + deltaLinha;
		 
		 if(deltaGeral == 1 && !diagonal)
		 {
			 vizinhos.add(vizinho);
			 return true;
		 }else if(deltaGeral == 2 && diagonal){
			 vizinhos.add(vizinho);
			 return true;
		 }else {
			 return false;
			 
		 }
		 
	 } //Fim do método adicinoarVizinhos
	 
	 public void alterarMarcacao(){
		 if(!aberto) {
			 marcado = !marcado;
		 }
	 }
	 
	 public boolean abrir() {
		 
		 if(!aberto && !marcado) {
			 aberto = true;
			 
			 if(minado) {
				 throw new explosaoExcetion();
			 }
			 
			 if(vizinhancaSegura()){
				 vizinhos.forEach(v -> v.abrir());
			 }
			 return true;
		 }else {
			 return false;
		 }
		 
	 }
	 
	 public boolean vizinhancaSegura() {
		 return vizinhos.stream().noneMatch(v -> v.minado);
	 }
	 
	 public boolean isMarcado() {
		 return marcado;
	 }
	 public void minar() {
		 minado = true;
	 }
	 public boolean isAberto() {
		 return aberto;
	 }
	 
	 public boolean isFechado() {
		 return !isAberto();
	 }
	 public boolean isMinado() {
		 return minado;
	 }

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	public boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		
		return desvendado || protegido;
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	public String toString() {
		if(marcado) {
			return "X";
		}else if(aberto && minado) {
			return "*";
			
		} else if(aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
			
		}else {
			return "?";
		}
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
}
