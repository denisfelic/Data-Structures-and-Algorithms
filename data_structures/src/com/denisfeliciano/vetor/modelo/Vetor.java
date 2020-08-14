package com.denisfeliciano.vetor.modelo;

import java.util.Arrays;

public class Vetor {

	private String[] elementos;
	private int quantidadeItemsNoVetor = 0;
	private int CAPACIDADE_MAX_ITEMS_VETOR;

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.CAPACIDADE_MAX_ITEMS_VETOR = capacidade;
	}

	public int getCapacidadeMaximaElementosAtual() {
		return this.CAPACIDADE_MAX_ITEMS_VETOR;
	}

	public void adiciona(String elemento) {
		verificaSePodeAdicionarElementoNoVetor();

		this.elementos[quantidadeItemsNoVetor] = elemento;
		quantidadeItemsNoVetor++;

	}

	/**
	 * 
	 */
	private void verificaSePodeAdicionarElementoNoVetor() {
		if (quantidadeItemsNoVetor >= CAPACIDADE_MAX_ITEMS_VETOR)
			throw new ArrayIndexOutOfBoundsException("Capacidade m�xima do Vetor atingida!");
	}

	public Integer getQuantidadeDeItems() {
		return this.quantidadeItemsNoVetor;
	}

	public Object getElemento(int indiceElemento) {
		verificaSeIndiceDoVetorEvalido(indiceElemento);
		return this.elementos[indiceElemento];
	}

	/**
	 * @param indiceElemento
	 */
	private void verificaSeIndiceDoVetorEvalido(int indiceElemento) {
		if (indiceElemento < 0 || indiceElemento >= quantidadeItemsNoVetor)
			throw new IllegalArgumentException(
					"Argumento invalido, o indice " + indiceElemento + " n�o existe no Vetor ou " + "est� nulo.");
	}

	@Override
	public String toString() {
		return Arrays.toString(elementos);
	}

	public int elementExiste(String elementoProcurado) {
		
		for (int i=0; i< this.quantidadeItemsNoVetor; i++)
			if (this.elementos[i].equals(elementoProcurado))
				return i;
		
		return -1;
	}

}
