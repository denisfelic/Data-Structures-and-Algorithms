package com.denisfeliciano.pilha.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.denisfeliciano.pilha.modelo.Pilha;

public class TestPilha {

	@Test
	public void deveRetornarUltimoElementoPilha() {

		Pilha<String> pilha = new Pilha<String>(5);
		pilha.empilha("A");
		pilha.empilha("B");
		pilha.empilha("C");

		assertEquals(5, pilha.getCapacidadeMaximaElementosAtual());
		assertEquals(3, pilha.getTotalDeElementos());
		assertEquals("C", pilha.ultimoElementoPilha());
	}
	
	@Test
	public void deveRetornarCasoPilhaEstejaVazia() {

		Pilha<String> pilha = new Pilha<String>(5);
	

		assertEquals(5, pilha.getCapacidadeMaximaElementosAtual());
		assertEquals(0, pilha.getTotalDeElementos());
		assertEquals(null, pilha.ultimoElementoPilha());
	}

	@Test
	public void deveRetornarTrueCasoEsteVazia() {

		Pilha<String> pilha = new Pilha<String>(5);
		boolean resAntes = pilha.verificaSeEstaVAzia();

		pilha.adiciona("X");
		boolean resDepois = pilha.verificaSeEstaVAzia();

		assertEquals(true, resAntes);
		assertEquals(false, resDepois);
	}
	
	@Test
	public void deveRemoverItemPilha() {
		Pilha<String> pilha = new Pilha<String>(5);
		pilha.empilha("A");
		pilha.empilha("B");
		pilha.empilha("C");

		String objDesempilhado = pilha.desempilha();
		
		assertEquals(5, pilha.getCapacidadeMaximaElementosAtual());
		assertEquals(2, pilha.getTotalDeElementos());
		assertEquals("C", objDesempilhado);
		assertEquals("B", pilha.ultimoElementoPilha());
	}
	
	@Test
	public void deveRetornarNuloCasoTenteRemoverElementoInexistente() {
		Pilha<String> pilha = new Pilha<String>(5);
		
		String objDesempilhado = pilha.desempilha();
		
		assertEquals(5, pilha.getCapacidadeMaximaElementosAtual());
		assertEquals(0, pilha.getTotalDeElementos());
		assertEquals(null, objDesempilhado);
	}

}
