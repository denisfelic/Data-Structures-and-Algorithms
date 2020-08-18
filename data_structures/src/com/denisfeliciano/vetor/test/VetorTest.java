package com.denisfeliciano.vetor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.denisfeliciano.vetor.modelo.Vetor;
import com.denisfeliciano.vetor.test.mock.TestPessoa;

public class VetorTest {
	// cenario - ação - validação
	@Test
	public void deveCriarUmVetorComCapacidadeMaiorQueZero() {

		Vetor vetor = new Vetor(5);
		Vetor vetor2 = new Vetor(1);

		assertEquals(5, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(1, vetor2.getCapacidadeMaximaElementosAtual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoCasoCapacidadeSejaMenorQue1() {
		Vetor veto2 = new Vetor(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoCasoCapacidadeSejaMenoIgualZero() {
		Vetor veto2 = new Vetor(0);
	}

	@Test
	public void deveAdicionarUmElementoAoFinalDoVetor() {

		Vetor vetor = new Vetor(2);

		vetor.adiciona("Denis");
		vetor.adiciona("Camila");

		assertEquals(2, vetor.getTotalDeElementos());
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
		assertEquals(5, vetor.getTotalDeElementos());
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

		assertEquals(3, vetor.getTotalDeElementos());
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

		assertEquals(7, vetor.getTotalDeElementos());
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

		assertEquals(7, vetor.getTotalDeElementos());
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

		assertEquals(4, vetor.getTotalDeElementos());
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
		int qtdElementosAntesRemover = vetor.getTotalDeElementos();
		vetor.remove("B");
		int qtdElementosDepoisRemover = vetor.getTotalDeElementos();

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
		assertEquals(3, vetor.getTotalDeElementos());
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
		assertEquals(3, vetor.getTotalDeElementos());
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
		assertEquals(2, vetor.getTotalDeElementos());
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

		assertEquals(5, vetor.getTotalDeElementos());
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

		assertEquals(3, vetor.getTotalDeElementos());
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

		assertEquals(1, vetor.getTotalDeElementos());
		assertEquals(p2, vetor.getElemento(0));

	}

	@Test
	public void deveRetornarTrueCasoTenhaAoMenosUmElementNoVetor() {
		Vetor<TestPessoa> vetor = new Vetor(5);

		TestPessoa p1 = new TestPessoa(23, "Marcos", "3424342");
		TestPessoa p2 = new TestPessoa(22, "Elena", "23123");
		TestPessoa p3 = new TestPessoa(21, "Richard", "438485");
		TestPessoa cp_p1 = p1;

		vetor.adiciona(p1);
		vetor.adiciona(p2);
		vetor.adiciona(p3);
		vetor.adiciona(cp_p1);

		assertEquals(4, vetor.getTotalDeElementos());
		assertEquals(true, vetor.contains(cp_p1));
	}

	@Test
	public void deveRetornarFalseCasoElementoNaoEstejaContidoNoVetor() {

		Vetor vetor = new Vetor(5);

		TestPessoa p1 = new TestPessoa(23, "Marcos", "3424342");
		TestPessoa p2 = new TestPessoa(22, "Elena", "23123");
		TestPessoa p3 = new TestPessoa(21, "Richard", "438485");
		TestPessoa p4 = new TestPessoa(21, "Mônica", "438485");
		TestPessoa cp_p1 = p1;

		vetor.adiciona(p1);
		vetor.adiciona(p2);
		vetor.adiciona(p3);
		vetor.adiciona(cp_p1);

		assertEquals(4, vetor.getTotalDeElementos());
		assertEquals(true, vetor.contains(cp_p1));
		assertEquals(false, vetor.contains(p4));
	}

	@Test
	public void deveRetornarIndiceDaUltimaOcorrenciaCasoExistaNoVetor() {
		Vetor<String> vetor = new Vetor(5);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("A");
		vetor.adiciona("C");

		assertEquals(4, vetor.getTotalDeElementos());
		assertEquals(2, vetor.lastIndexOf("A"));
	}

	@Test
	public void deveRetornaMenosUmCasoNaoEnconterNenhumaOcorrenciaNoVetor() {
		Vetor<String> vetor = new Vetor(5);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("A");
		vetor.adiciona("C");

		assertEquals(4, vetor.getTotalDeElementos());
		assertEquals(-1, vetor.lastIndexOf("Z"));
	}

	@Test
	public void deveRemoverTodosElementosDoVetor() {
		Vetor<String> vetor = new Vetor(10);

		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("A");

		int qtdItemsAntesRemover = vetor.getTotalDeElementos();
		int capacidadeAntesRemover = vetor.getCapacidadeMaximaElementosAtual();
		vetor.clear();

		assertEquals(4, qtdItemsAntesRemover);
		assertEquals(10, capacidadeAntesRemover);
		assertEquals(0, vetor.getTotalDeElementos());
		assertEquals(10, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(-1, vetor.getElemento("A"));
	}

	@Test
	public void deveAdicionar30ItemsNoVetor() {

		Vetor vetor = new Vetor(30);

		for (int i = 0; i < 30; i++) {
			vetor.adiciona(new TestPessoa(i + 1, "Test" + i, "00321-" + i));
		}

		assertEquals(40, vetor.getCapacidadeMaximaElementosAtual());
		assertEquals(30, vetor.getTotalDeElementos());
	}
}
