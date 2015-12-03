package br.com.structural.composite;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Problema inicial
 * 
 * class Empregado { double calculaSalrio() { return 1000; } }
 * 
 * class Supervisor { double calculaSalario() { return 1500; } }
 * 
 * 
 * class Gerente { double calculaSalario() { return 2500; } }
 **/

interface Celetista {
	double calculaSalario();
}

class Empregado implements Celetista {
	String nome;
	public double calculaSalario() {
		System.out.println("Chamada empregado: " + nome);
		return 1000;
	}
}

class Supervisor implements Celetista {
	String nome;
	ArrayList<Celetista> celetistas = new ArrayList<Celetista>();
	double abono = 0.0;

	public double calculaSalario() {
		for (Celetista celetista : celetistas) {
			abono += celetista.calculaSalario() * 0.1;
		}
		System.out.println("Chamada Supervisor: " + nome);
		return 1500 + abono;
	}
}

class Gerente implements Celetista {
	String nome;
	ArrayList<Celetista> celetistas = new ArrayList<Celetista>();
	double abono = 0.0;

	public double calculaSalario() {
		for (Celetista celetista : celetistas) {
			abono += celetista.calculaSalario() * 0.1;
		}
		System.out.println("Chamada Gerente: " + nome);
		return 2500 + abono;
	}
}

public class PattnerComposite {
	
	public static void main(String[] args) {
		Empregado emp1 = new Empregado();
		emp1.nome = "Golino";
		Empregado emp2 = new Empregado();
		emp2.nome = "Marco";
		Empregado emp3 = new Empregado();
		emp3.nome = "Pato Donalds";
		
		Supervisor sup1 = new Supervisor();
		sup1.celetistas.add(emp1);
		sup1.celetistas.add(emp2);
		sup1.celetistas.add(emp3);
		sup1.nome ="Supervisor 1";
		
		System.out.println("Salário Supervisor 1: " + sup1.calculaSalario());
		
		Supervisor sup2 = new Supervisor();
		sup2.celetistas.add(emp1);
		sup2.celetistas.add(emp3);
		sup2.nome ="Supervisor 2";
		
		System.out.println("Salário Supervisor 2: " + sup2.calculaSalario()); 
		
		Gerente g1 = new Gerente();
		g1.celetistas.add(sup1);
		g1.celetistas.add(sup2);
		g1.nome = "Fred";
		
		System.out.println("Salário Gerente 1: " + g1.calculaSalario()); 
		
	}

}
