package br.com.coder.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.coder.cm.execesao.SairException;
import br.com.coder.cm.execesao.explosaoExcetion;
import br.com.coder.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
		
		executarJogo();
		
	}
	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				
				cicloDoJogo();
				
				System.out.println("Outra Partida?");
				String resposta = entrada.next();
				
				if("n".equalsIgnoreCase("resposta")) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		}finally {
			entrada.close();
		}
	}
	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigtado("Digite (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigtado("1 - Abir ou 2 (Des)Marcar");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(),xy.next());
					
				}else if("2".equals(digitado)) {
					tabuleiro.marcar(xy.next(),xy.next());
				}
			}
			
			
			System.out.println("Você Ganhou!!!");
		} catch (explosaoExcetion e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
		}
		
	}
	private String capturarValorDigtado(String texto) {
		System.out.println(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equals(digitado)) {
			throw new SairException();
		}
			return digitado;
	}
	
}
