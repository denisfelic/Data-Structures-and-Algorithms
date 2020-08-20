package com.denisfeliciano.fila;

import com.denisfeliciano.estrutura.generica.EstruturaDadosGenerica;

public class Fila<T> extends EstruturaDadosGenerica<T> {

	private int numeroElementosFila;

	public Fila(int capacidade) {
		super(capacidade);
		// TODO Auto-generated constructor stub
	}

	public T enfileira(T obj) {
		this.adiciona(obj);
		return obj;
	}

	public T desemfileira() {
		this.remove(numeroElementosFila);
		return this.getElemento(numeroElementosFila);
	}

	public T espiar() {
		return this.getElemento(0);
	}

}
