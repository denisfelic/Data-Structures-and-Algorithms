package com.denisfeliciano.vetor.modelo;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.denisfeliciano.estrutura.generica.EstruturaDadosGenerica;

public class Vetor<T> extends EstruturaDadosGenerica<T> {

	public Vetor(int capacidade) {
		super(capacidade);
		// TODO Auto-generated constructor stub
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
			throw new IllegalArgumentException("Impossivel remover o elemento, pois o mesmo" + "não existe no Vetor!");
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

	

	/**
	 * @param indiceElemento
	 */
	private void verificaSeIndiceDoVetorEvalido(int indiceElemento) {
		if (indiceElemento < 0 || indiceElemento >= quantidadeItemsNoVetor)
			throw new IllegalArgumentException(
					"Argumento invalido, o indice " + indiceElemento + " não existe no Vetor ou " + "está nulo.");
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

	public Integer lastIndexOf(T object) {
		for (int i = this.quantidadeItemsNoVetor - 1; i >= 0; i--)
			if (this.elementos[i].equals(object))
				return i;

		return -1;
	}

	public void clear() {
		this.elementos = (T[]) new Object[this.CapacidadeMaximaItemsDoVetor];
		this.quantidadeItemsNoVetor = 0;
	}

}
