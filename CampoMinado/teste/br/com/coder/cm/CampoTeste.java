package br.com.coder.cm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.coder.cm.execesao.explosaoExcetion;
import br.com.coder.cm.modelo.Campo;

public class CampoTeste {
	
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
	}
	@Test
	void testeVizinhoRealDistancia3() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
	}
	
	@Test
	void testeVizinhoRealDistancia4() {
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
		
	}
	@Test
	void testeValorPadraoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacao() {
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacaoDuasVezes() {
		campo.alterarMarcacao();
		campo.alterarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbriNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(explosaoExcetion.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	
	
	

}
