package com.denisfeliciano.estrutura.generica;

import java.lang.reflect.Array;

public class EstruturaDadosGenerica<T> {

	protected T[] elementos;
	protected int CapacidadeMaximaItemsDoVetor;
	protected int quantidadeItemsNoVetor = 0;
	protected static final int CAPACIDADE_NOVA = 10;

	public EstruturaDadosGenerica(int capacidade) {
		verificaCapacidadeVetor(capacidade);
		this.elementos = (T[]) new Object[capacidade];
		this.CapacidadeMaximaItemsDoVetor = capacidade;
	}

	public EstruturaDadosGenerica(int capacidade, Class tipoClasse) {
		verificaCapacidadeVetor(capacidade);
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.CapacidadeMaximaItemsDoVetor = capacidade;
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

	public void remove(int index) {
		verificaSeIndiceDoVetorEvalido(index);
		this.elementos[index] = null;
		ordenarVetorApartirDaPosicao(index);
	}

	public void remove(T elemento) {
		int posicaoElemento = this.getElemento(elemento);
		if (!(posicaoElemento > -1)) {
			throw new IllegalArgumentException("Impossivel remover o elemento, pois o mesmo" + "n�o existe no Vetor!");
		}
		this.elementos[posicaoElemento] = null;
		ordenarVetorApartirDaPosicao(posicaoElemento);

	}

	public T getElemento(int indiceElemento) {
		verificaSeIndiceDoVetorEvalido(indiceElemento);
		return this.elementos[indiceElemento];
	}

	public int getElemento(T elementoProcurado) {

		for (int i = 0; i < this.quantidadeItemsNoVetor; i++)
			if (this.elementos[i].equals(elementoProcurado))
				return i;

		return -1;
	}

	public boolean verificaSeEstaVAzia() {
		return this.quantidadeItemsNoVetor == 0;

	}

	public boolean contains(T elementoProcurado) {
		return getElemento(elementoProcurado) >= 0;
	}

	public int getCapacidadeMaximaElementosAtual() {
		return this.CapacidadeMaximaItemsDoVetor;
	}

	public Integer getTotalDeElementos() {
		return this.quantidadeItemsNoVetor;
	}

	@Override
	public String toString() {
		String toString = "[";
		for (T e : this.elementos) {
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

	protected void verificaCapacidadeVetor() {
		if (quantidadeItemsNoVetor >= CapacidadeMaximaItemsDoVetor - 1) {

			adicionaMaisDezDeCapacidadeTotal();
		}
	}

	protected void verificaElementoValido(T object) {
		if (object == null)
			throw new IllegalArgumentException("O objeto n�o pode ser nulo!");

	}

	/**
	 * @param indiceElemento
	 */
	private void verificaSeIndiceDoVetorEvalido(int indiceElemento) {
		if (indiceElemento < 0 || indiceElemento >= quantidadeItemsNoVetor)
			throw new IllegalArgumentException(
					"Argumento invalido, o indice " + indiceElemento + " n�o existe no Vetor ou " + "est� nulo.");
	}

	private void ordenarVetorApartirDaPosicao(int index) {
		for (int i = index; i <= this.quantidadeItemsNoVetor; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.elementos[quantidadeItemsNoVetor - 1] = null;
		this.quantidadeItemsNoVetor--;
	}

	/**
	 * @param capacidade
	 * @throws IllegalArgumentException
	 */
	private void verificaCapacidadeVetor(int capacidade) throws IllegalArgumentException {
		if (capacidade < 1) {
			throw new IllegalArgumentException("Capacidade do vetor deve ser maior que \"0\".");
		}
	}

	private void adicionaMaisDezDeCapacidadeTotal() {
		T[] ts = (T[]) new Object[this.CapacidadeMaximaItemsDoVetor + CAPACIDADE_NOVA];
		T[] newElements = ts;
		this.CapacidadeMaximaItemsDoVetor = newElements.length;

		for (int i = 0; i < this.elementos.length; i++) {
			newElements[i] = this.elementos[i];
		}

		this.elementos = newElements;
	}
}
