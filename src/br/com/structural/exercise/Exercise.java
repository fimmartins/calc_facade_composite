package br.com.structural.exercise;

import java.util.LinkedList;

interface Operation {
	double calcular(double num1, double num2);
}

class Mulplica implements Operation {

	@Override
	public double calcular(double num1, double num2) {
		return num1 * num2;
	}

}

class Soma implements Operation {

	@Override
	public double calcular(double num1, double num2) {
		return num1 + num2;
	}

}

class Subtracao implements Operation {

	@Override
	public double calcular(double num1, double num2) {
		return num1 - num2;
	}

}

class Divisao implements Operation {

	@Override
	public double calcular(double num1, double num2) {
		return num1 / num2;
	}

}

class Fachada12C {

	double calcular(String string) {
		double resultado = 0.0;
		LinkedList<Double> operacoesPrimarias = new LinkedList<Double>();
		LinkedList<Double> operacoesSecundarias = new LinkedList<Double>();
		Mulplica mulplica = new Mulplica();
		Soma soma = new Soma();
		Divisao divisao = new Divisao();
		Subtracao subtracao = new Subtracao();

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '+') {
				if (operacoesPrimarias.size() >= 2) {
					resultado = soma.calcular(operacoesPrimarias.get(0), operacoesPrimarias.get(1));
					operacoesPrimarias.removeFirst();
					operacoesPrimarias.removeFirst();
					operacoesSecundarias.add(resultado);
				} else if (operacoesSecundarias.size() >= 2) {
					resultado = soma.calcular(operacoesSecundarias.get(0), operacoesSecundarias.get(1));
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.add(resultado);
				}

			} else if (string.charAt(i) == '-') {
				if (operacoesPrimarias.size() >= 2) {
					resultado = subtracao.calcular(operacoesPrimarias.get(0), operacoesPrimarias.get(1));
					operacoesPrimarias.removeFirst();
					operacoesPrimarias.removeFirst();
					operacoesSecundarias.add(resultado);
				} else if (operacoesSecundarias.size() >= 2) {
					resultado = subtracao.calcular(operacoesSecundarias.get(0), operacoesSecundarias.get(1));
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.add(resultado);
				}

			} else if (string.charAt(i) == '/') {
				if (operacoesPrimarias.size() >= 2) {
					resultado = divisao.calcular(operacoesPrimarias.get(0), operacoesPrimarias.get(1));
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.add(resultado);
				} else if (operacoesSecundarias.size() >= 2) {
					resultado = divisao.calcular(operacoesSecundarias.get(0), operacoesSecundarias.get(1));
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.add(resultado);
				}

			} else if (string.charAt(i) == '*') {
				if (operacoesPrimarias.size() >= 2) {
					resultado = mulplica.calcular(operacoesPrimarias.get(0), operacoesPrimarias.get(1));
					operacoesPrimarias.removeFirst();
					operacoesPrimarias.removeFirst();
					operacoesSecundarias.add(resultado);
				} else if (operacoesSecundarias.size() >= 2) {
					resultado = mulplica.calcular(operacoesSecundarias.get(0), operacoesSecundarias.get(1));
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.removeFirst();
					operacoesSecundarias.add(resultado);
				}

			} else {
				operacoesPrimarias.add((double) Character.digit(string.charAt(i), 10));
			}
		}

		return operacoesSecundarias.getFirst();
	}
}

public class Exercise {
	
	public static void main(String[] args)
	{
		Fachada12C calc12c = new Fachada12C();
		System.out.println(calc12c.calcular("43+63-*"));
	}

}
