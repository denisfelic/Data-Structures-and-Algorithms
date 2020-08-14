package com.denisfeliciano.vetor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.denisfeliciano.vetor.modelo.Vetor;

public class VetorTest {
	// cenario - ação - validação
	@Test
	public void deveCriarUmVetorComCapacidade5() {

		Vetor vetor = new Vetor(5);

		assertEquals(5, vetor.getCapacidadeMaximaElementosAtual());
	}

	@Test
	public void deveAdicionarUmElementoAoFinalDoVetor() {

		Vetor vetor = new Vetor(2);

		vetor.adiciona("Denis");
		vetor.adiciona("Camila");

		assertEquals(2, vetor.getQuantidadeDeItems());
		assertEquals("Denis", vetor.getElemento(0));
		assertEquals("Camila", vetor.getElemento(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deveLancarExcecaoCasoExcedaCapacidadeMaximaDeElementosDoVetor() {

		Vetor vetor = new Vetor(2);
		vetor.adiciona("Denis");
		vetor.adiciona("Camila");
		vetor.adiciona("Kelvin");

	}

	@Test
	public void deveImprimirTodosOsElementosDoVetor() {

		Vetor vetor = new Vetor(5);
		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");
		vetor.adiciona("Elemento 3");
		vetor.adiciona("Elemento 4");
		vetor.adiciona("Elemento 5");

		String vetortoString = "[Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5]";

		assertEquals(5, vetor.getQuantidadeDeItems());
		assertEquals("Elemento 1", vetor.getElemento(0));
		assertEquals("Elemento 2", vetor.getElemento(1));
		assertEquals("Elemento 3", vetor.getElemento(2));
		assertEquals("Elemento 4", vetor.getElemento(3));
		assertEquals("Elemento 5", vetor.getElemento(4));
		assertEquals(vetortoString, vetor.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveDarExcecaoCasoUsuarioPasseArgumentoMaiorQueQuantidadeDeItemsPresentesNoVetor() {

		Vetor vetor = new Vetor(2);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");

		vetor.getElemento(2);
		vetor.getElemento(0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void deveDarExcecaoCasoUsuarioBusqueElementoNoVetorEpasseArgumentoMenorQueZero() {

		Vetor vetor = new Vetor(2);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");

		vetor.getElemento(0);
		vetor.getElemento(-2);

	}

	@Test
	public void deveRetornarPosicaoElementoPassadoComoArgumento() {

		Vetor vetor = new Vetor(3);
		vetor.adiciona("Denis");
		vetor.adiciona("Lucas");
		vetor.adiciona("Kaique");

		int posicaoElemento = vetor.elementExiste("Denis");
		assertEquals(0, posicaoElemento);

	}

	@Test
	public void deveRetornarMenos1CasoNaoEncontreOElemento() {

		Vetor vetor = new Vetor(3);
		vetor.adiciona("Denis");
		vetor.adiciona("Lucas");
		vetor.adiciona("Kaique");

		int posicaoElementoNaoExistente1 = vetor.elementExiste("Mauro");
		int posicaoElementoNaoExistente2 = vetor.elementExiste("");
		
		assertEquals(3, vetor.getQuantidadeDeItems());
		assertEquals(-1, posicaoElementoNaoExistente1);
		assertEquals(-1, posicaoElementoNaoExistente2);
	}
	
	

}
