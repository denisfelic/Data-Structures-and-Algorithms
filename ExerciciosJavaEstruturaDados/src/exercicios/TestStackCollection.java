package exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.Test;

 
public class TestStackCollection {

	@Test
	public void deveAdicionarUmItemNaStack() {

		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		assertEquals(3, stack.size());
		assertEquals("A", stack.firstElement());
		assertEquals("C", stack.lastElement());

	}

	@Test
	public void deveRemoverUltimoElementoDaStack() {

		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();

		assertEquals(2, stack.size());
		assertEquals("A", stack.firstElement());
		assertEquals("B", stack.peek());

	}

	@Test
	public void exercicio() {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= 11; i++) {
			if (i % 2 != 0) {
				stack.push(i);
			} else {
				if (!stack.isEmpty())
					stack.pop();
			}

		}
		if (!stack.isEmpty())
			stack.clear();

 	}

	@Test
	public void exercicio2() {
		Stack<Integer> stackPar = new Stack<Integer>();
		Stack<Integer> stackImpar = new Stack<Integer>();

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				if (stackImpar.isEmpty()) {
 					continue;
				}
				if (stackPar.isEmpty()) {
 					continue;
				}

				stackImpar.pop();
				stackPar.pop();
			}

			if (i % 2 == 0)
				stackPar.push(i);
			else {
				stackImpar.push(i);
			}
		}
 		int size = stackImpar.size();
		for (int i = 0; i < size; i++) {
 			stackImpar.pop();
		}

		size = stackPar.size();
		for (int i = 0; i < size; i++) {
 			stackPar.pop();
		}

	 
	}

	@Test
	public void exercicio4() {

		Palindromo palindromo = new Palindromo();

		
		assertEquals(true, palindromo.isPalindromo("AABCCBAA"));
		assertEquals(false, palindromo.isPalindromo("ABFFBB"));
		assertEquals(true, palindromo.isPalindromo("ADDFDDA"));

	}
	
	@Test
	public void exercicio5Calculadora() {
		
		VerificadorDeParenteses verificador = new VerificadorDeParenteses();
		
		assertEquals(true, verificador.check("(2+3)*5"));
		assertEquals(false, verificador.check("(2+3))*5"));
		assertEquals(false, verificador.check(")2+3))*23))9*("));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
