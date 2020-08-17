package com.denisfeliciano.vetor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.denisfeliciano.vetor.modelo.Vetor;
import com.denisfeliciano.vetor.test.mock.TestPessoa;

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

		int posicaoElemento = vetor.getElemento("Denis");
		assertEquals(0, posicaoElemento);

	}

	@Test
	public void deveRetornarMenos1CasoNaoEncontreOElemento() {

		Vetor vetor = new Vetor(3);
		vetor.adiciona("Denis");
		vetor.adiciona("Lucas");
		vetor.adiciona("Kaique");

		int posicaoElementoNaoExistente1 = vetor.getElemento("Mauro");
		int posicaoElementoNaoExistente2 = vetor.getElemento("");

		assertEquals(3, vetor.getQuantidadeDeItems());
		assertEquals(-1, posicaoElementoNaoExistente1);
		assertEquals(-1, posicaoElementoNaoExistente2);
	}

	@Test
	public void deveAtribuirUmElementoNaPrimeiraPosicaoDoVetor() {

		Vetor vetor = new Vetor(10);

		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");
		vetor.adiciona("G");

		vetor.adiciona(0, "A");

		assertEquals(7, vetor.getQuantidadeDeItems());
		assertEquals("A", vetor.getElemento(0));
		assertEquals("B", vetor.getElemento(1));
	}

	@Test
	public void deveAtribuirElementoNaUltimaPosicaoValidaDoVetor() {

		Vetor vetor = new Vetor(10);

		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");
		vetor.adiciona("G");

		vetor.adiciona(5, "A");

		assertEquals(7, vetor.getQuantidadeDeItems());
		assertEquals("B", vetor.getElemento(0));
		assertEquals("C", vetor.getElemento(1));
		assertEquals("A", vetor.getElemento(5));
		assertEquals("G", vetor.getElemento(6));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoCasoPosicaoExcedaNumeroDeItemsPresentes() {

		Vetor vetor = new Vetor(10);

		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");
		vetor.adiciona("G");

		vetor.adiciona(6, "A");

	}

	@Test
	public void deveAdicionarMais10SlotsNoVetorCasoExcederQuantidadeMaxima() {

		Vetor vetor = new Vetor(5);

		vetor.adiciona("1");
		vetor.adiciona("2");
		vetor.adiciona("3");
		vetor.adiciona("4");
		int capacidadeAntiga = vetor.getCapacidadeMaximaElementosAtual();
		vetor.adiciona("5");
		int capacidadeNova = vetor.getCapacidadeMaximaElementosAtual();
		vetor.adiciona("6");
		vetor.adiciona("7");

		assertEquals(5, capacidadeAntiga);
		assertEquals(15, capacidadeNova);
		assertEquals("7", vetor.getElemento(6));
	}

	@Test
	public void deveRemoverElementoDoVetorEmQualquerPosicaoValida() {

		Vetor vetor = new Vetor(5);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");

		vetor.remove(1);

		assertEquals(4, vetor.getQuantidadeDeItems());
		assertEquals("A", vetor.getElemento(0));
		assertEquals("C", vetor.getElemento(1));
		assertEquals("D", vetor.getElemento(2));
		assertEquals("E", vetor.getElemento(3));

	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoCasoArgumentoRemoverElementoNaoExistaNoVetor() {

		Vetor vetor = new Vetor(2);
		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.remove(5);
	}

	@Test
	public void deveRemoverPrimeiroElementoExistenteNoVetor() {
		Vetor vetor = new Vetor(5);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");
		int qtdElementosAntesRemover = vetor.getQuantidadeDeItems();
		vetor.remove("B");
		int qtdElementosDepoisRemover = vetor.getQuantidadeDeItems();

		assertEquals(5, qtdElementosAntesRemover);
		assertEquals(4, qtdElementosDepoisRemover);
		assertEquals("A", vetor.getElemento(0));
		assertEquals("C", vetor.getElemento(1));
		assertEquals("D", vetor.getElemento(2));
		assertEquals("E", vetor.getElemento(3));

	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoCasoTenteRemoverItemInexistente() {
		Vetor vetor = new Vetor(5);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");

		vetor.remove("X");
	}

	@Test
	public void deveAceitarElementosDoTipoInt() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona(5);
		vetor.adiciona(7);
		vetor.adiciona(2);
		assertEquals(3, vetor.getQuantidadeDeItems());
		assertEquals(5, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(5, vetor.getElemento(0));
		assertEquals(7, vetor.getElemento(1));
		assertEquals(2, vetor.getElemento(2));
	}

	@Test
	public void deveAceitarElementosDoTipoBoolean() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona(true);
		vetor.adiciona(false);
		vetor.adiciona(true);
		assertEquals(3, vetor.getQuantidadeDeItems());
		assertEquals(5, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(true, vetor.getElemento(0));
		assertEquals(false, vetor.getElemento(1));
		assertEquals(true, vetor.getElemento(2));
	}

	@Test
	public void deveRemoverElementosDoTipoBoolean() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona(true);
		vetor.adiciona(false);
		vetor.adiciona(true);

		vetor.remove(1);
		assertEquals(2, vetor.getQuantidadeDeItems());
		assertEquals(5, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(true, vetor.getElemento(0));
		assertEquals(true, vetor.getElemento(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarValoresNulos() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona(null);
		vetor.adiciona(null);
		vetor.adiciona(null);
	}

	@Test
	public void deveAceitarDiferentesTiposDeElementosNoVetor() {
		Vetor vetor = new Vetor(10);

		Object genericObject = new Object();

		vetor.adiciona("String");
		vetor.adiciona(true);
		vetor.adiciona(1.5);
		vetor.adiciona(5);
		vetor.adiciona(genericObject);

		assertEquals(5, vetor.getQuantidadeDeItems());
		assertEquals(10, vetor.getCapacidadeMaximaElementosAtual());

		assertEquals("String", vetor.getElemento(0));
		assertEquals(true, vetor.getElemento(1));
		assertEquals(1.5, vetor.getElemento(2));
		assertEquals(5, vetor.getElemento(3));
		assertEquals(genericObject, vetor.getElemento(4));

	}

	@Test
	public void deveAdicionarUmObjetoDeUmTipoEspecificoNoVetor() {
		Vetor<TestPessoa> vetor = new Vetor(5);

		TestPessoa p1 = new TestPessoa(55, "Maria", "66214442");
		TestPessoa p2 = new TestPessoa(23, "Joao", "41232133");
		TestPessoa p3 = new TestPessoa(40, "Pedro", "53464564");
		TestPessoa p4 = new TestPessoa(40, "Higor", "53464564");

		vetor.adiciona(p1);
		vetor.adiciona(p2);
		vetor.adiciona(p3);
		

		assertEquals(3, vetor.getQuantidadeDeItems());
		assertEquals(p1, vetor.getElemento(0));
		assertEquals(p2, vetor.getElemento(1));
		assertEquals(p3, vetor.getElemento(2));
 	}
	
	 
	
	@Test
	public void deveRemoverObjetoDeUmTipoEspecificoNoVetor() {
		Vetor vetor = new Vetor(5);

		TestPessoa p1 = new TestPessoa(55, "Maria", "66214442");
		TestPessoa p2 = new TestPessoa(23, "Joao", "41232133");
		TestPessoa p3 = new TestPessoa(40, "Pedro", "53464564");

		vetor.adiciona(p1);
		vetor.adiciona(p2);
		vetor.adiciona(p3);

		vetor.remove(p3);
		vetor.remove(0);
		
 		assertEquals(1, vetor.getQuantidadeDeItems());
		assertEquals(p2, vetor.getElemento(0));
 
	}
}
