package com.denisfeliciano.fila.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.denisfeliciano.fila.Fila;

public class TestFila {

	@Test
	public void deveAdicionarElementosNaFila() {

		Fila<String> fila = new Fila<String>(5);

		fila.enfileira("A");
		fila.enfileira("B");
		fila.enfileira("C");

		assertEquals(5, fila.getCapacidadeMaximaElementosAtual());
		assertEquals(3, fila.getTotalDeElementos());
		assertEquals("A", fila.espiar());
		assertEquals("B", fila.getElemento(1));
		assertEquals("C", fila.getElemento(2));

	}

	@Test
	public void deveRemoverElementosDaFilaMantendoOrdem() {

		Fila<String> fila = new Fila<String>(10);

		fila.enfileira("A");
		fila.enfileira("B");
		fila.enfileira("C");
		fila.enfileira("E");

		fila.desemfileira();

		assertEquals(10, fila.getCapacidadeMaximaElementosAtual());
		assertEquals(3, fila.getTotalDeElementos());
 		assertEquals("B", fila.espiar());

	}
}
