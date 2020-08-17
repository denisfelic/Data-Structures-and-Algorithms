package com.denisfeliciano.vetor.modelo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vetor<T> {

	private static final int CAPACIDADE_NOVA = 10;
	private T[] elementos;
	private int quantidadeItemsNoVetor = 0;
	private int CapacidadeMaximaItemsDoVetor;

	public Vetor(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.CapacidadeMaximaItemsDoVetor = capacidade;
	}

	public Vetor(int capacidade, Class tipoClasse) {
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.CapacidadeMaximaItemsDoVetor = capacidade;
	}

	public int getCapacidadeMaximaElementosAtual() {
		return this.CapacidadeMaximaItemsDoVetor;
	}

	public void adiciona(T elemento) {
		verificaCapacidadeVetor();
		verificaElementoValido(elemento);

		this.elementos[quantidadeItemsNoVetor] = elemento;
		quantidadeItemsNoVetor++;

	}

	/**
	 * 
	 * @param posicao
	 * @param elemento
	 */
	public void adiciona(int posicao, T elemento) {
		verificaSeIndiceDoVetorEvalido(posicao);
		verificaElementoValido(elemento);

		for (int i = this.quantidadeItemsNoVetor; i >= posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.quantidadeItemsNoVetor++;

	}

	private void verificaElementoValido(T object) {
		if (object == null)
			throw new IllegalArgumentException("O objeto n�o pode ser nulo!");

	}

	/**
	 * 
	 */
	private void verificaCapacidadeVetor() {
		if (quantidadeItemsNoVetor >= CapacidadeMaximaItemsDoVetor - 1) {

			adicionaMaisDezDeCapacidadeTotal();
		}

	}

	/**
	 * 
	 */
	private void adicionaMaisDezDeCapacidadeTotal() {
		T[] newElements = (T[]) new Object[this.CapacidadeMaximaItemsDoVetor + CAPACIDADE_NOVA];
		this.CapacidadeMaximaItemsDoVetor = newElements.length;

		for (int i = 0; i < this.elementos.length; i++) {
			newElements[i] = this.elementos[i];
		}

		this.elementos = newElements;
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
		String toString = "[";
		for (Object e : this.elementos) {
			if (e != null) {
				toString = toString.concat(e.toString());
				toString = toString.concat(", ");
			}

			if (e == null) {
				toString = toString.substring(0, toString.length() - 2);
				toString = toString.concat("]");
				break;
			}

		}
		return toString;
	}

	public int getElemento(Object elementoProcurado) {

		for (int i = 0; i < this.quantidadeItemsNoVetor; i++)
			if (this.elementos[i].equals(elementoProcurado))
				return i;

		return -1;
	}

	public void remove(int index) {
		verificaSeIndiceDoVetorEvalido(index);
		this.elementos[index] = null;
		ordenarVetorApartirDaPosicao(index);
	}

	/**
	 * @param index
	 */
	private void ordenarVetorApartirDaPosicao(int index) {
		for (int i = index; i <= this.quantidadeItemsNoVetor; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.elementos[quantidadeItemsNoVetor - 1] = null;
		this.quantidadeItemsNoVetor--;
	}

	public void remove(Object elemento) {
		int posicaoElemento = this.getElemento(elemento);
		if (!(posicaoElemento > -1)) {
			throw new IllegalArgumentException("Impossivel remover o elemento, pois o mesmo" + "n�o existe no Vetor!");
		}
		this.elementos[posicaoElemento] = null;
		ordenarVetorApartirDaPosicao(posicaoElemento);

	}

}
