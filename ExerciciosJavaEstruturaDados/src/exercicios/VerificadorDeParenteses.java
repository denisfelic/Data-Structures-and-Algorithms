package exercicios;

import com.denisfeliciano.pilha.modelo.Pilha;

public class VerificadorDeParenteses {

	private int parentesesAbertos;
	private int parentesesFechados;

	public boolean check(String str) {

		for (int i = 0; i < str.length(); i++) {
			String chr = str.substring(i, i + 1);
			if (chr.equals("("))
				parentesesAbertos++;

			if (chr.equals(")"))
				parentesesFechados++;

		}

		if (parentesesAbertos != parentesesFechados)
			return false;

		return true;
	}
}
