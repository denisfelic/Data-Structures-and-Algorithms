package com.denisfeliciano.pilha.modelo;

import com.denisfeliciano.estrutura.generica.EstruturaDadosGenerica;

public class Pilha<T> extends EstruturaDadosGenerica<T> {

	public Pilha(int capacidade) {
		super(capacidade);
	}

	public void empilha(T element) {
		super.adiciona(element);
	}

	public T ultimoElementoPilha() {
		if (super.quantidadeItemsNoVetor == 0)
			return null;

		return super.getElemento(super.quantidadeItemsNoVetor - 1);
	}

	public T desempilha() {
		if(verificaSeEstaVAzia()) {
			return null;
		}
		
		T elementoDesempilhado = ultimoElementoPilha();
		super.remove(super.quantidadeItemsNoVetor-1);
		return elementoDesempilhado;
	}

}
