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
	 * @param posicao
	 * @param elemento
	 */
	public void adiciona(int posicao, String elemento) {
		verificaSeIndiceDoVetorEvalido(posicao);
		
		for (int i = this.quantidadeItemsNoVetor; i >= posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.quantidadeItemsNoVetor++;

	}

	/**
	 * 
	 */
	private void verificaSePodeAdicionarElementoNoVetor() {
		if (quantidadeItemsNoVetor >= CAPACIDADE_MAX_ITEMS_VETOR)
			throw new ArrayIndexOutOfBoundsException("Capacidade máxima do Vetor atingida!");
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
					"Argumento invalido, o indice " + indiceElemento + " não existe no Vetor ou " + "está nulo.");
	}

	@Override
	public String toString() {
		return Arrays.toString(elementos);
	}

	public int elementExiste(String elementoProcurado) {

		for (int i = 0; i < this.quantidadeItemsNoVetor; i++)
			if (this.elementos[i].equals(elementoProcurado))
				return i;

		return -1;
	}

}
