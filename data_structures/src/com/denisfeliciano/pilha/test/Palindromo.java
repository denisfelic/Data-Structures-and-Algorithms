package com.denisfeliciano.pilha.test;

import com.denisfeliciano.pilha.modelo.Pilha;

public class Palindromo {
	Pilha<String> primeiraMetade;
	Pilha<String> segundaMetade;

	public boolean isPalindromo(String palindromo) {

		primeiraMetade = new Pilha<>(palindromo.length());
		segundaMetade = new Pilha<>(palindromo.length());
		adicionaPrimeiraMetade(palindromo);
		adicionaSegundaMetade(palindromo);
		return verificaSeEPalindromo(palindromo);

	}

	/**
	 * @param palindromo
	 * @return
	 */
	private boolean verificaSeEPalindromo(String palindromo) {
		int numberOsEquals = 0;
		numberOsEquals = comprararElementosDasDuasListas(palindromo, numberOsEquals);
		if (numberOsEquals == palindromo.length() / 2)
			return true;
		else
			return false;
	}

	/**
	 * @param palindromo
	 * @param numberOsEquals
	 * @return
	 */
	private int comprararElementosDasDuasListas(String palindromo, int numberOsEquals) {
		if (primeiraMetade.getTotalDeElementos() != segundaMetade.getTotalDeElementos())
			return -1;

		for (int i = 0; i < palindromo.length() / 2; i++) {
			if (verificaSeElementosDasDuasListasSaoIguaisNaPosicao(i)) {
				numberOsEquals++;
			}

		}
		return numberOsEquals;
	}

	/**
	 * @param i
	 * @return
	 */
	private boolean verificaSeElementosDasDuasListasSaoIguaisNaPosicao(int i) {
		return primeiraMetade.getElemento(i).equals(segundaMetade.getElemento(i));
	}

	/**
	 * @param palindromo
	 */
	private void adicionaSegundaMetade(String palindromo) {
	 
		for (int i = palindromo.length(); i > palindromo.length() / 2; i--) {
			if (i == palindromo.length() / 2) {
				segundaMetade.adiciona(palindromo.substring(i, i));
				break;
			}
			segundaMetade.adiciona(palindromo.substring(i - 1, i));
		}
 
	}

	/**
	 * @param palindromo
	 */
	private void adicionaPrimeiraMetade(String palindromo) {
	
		for (int i = 0; i < palindromo.length() / 2; i++) {
			if (i == palindromo.length() - 1) {
				primeiraMetade.adiciona(palindromo.substring(i, i));
				break;
			}

			primeiraMetade.adiciona(palindromo.substring(i, i + 1));
		}
		
		verificaSeQuantidadeElementosImpar(palindromo);
 	}

	/**
	 * @param palindromo
	 */
	private void verificaSeQuantidadeElementosImpar(String palindromo) {
		String charPosicaoImpar = "";
		boolean temImpar = false;

		if (palindromo.length() % 2 != 0) {
			temImpar = true;
			charPosicaoImpar = palindromo.substring((palindromo.length() / 2), (palindromo.length() / 2) + 1);
 		}

		if (temImpar)
			primeiraMetade.adiciona(charPosicaoImpar);
	}

}
