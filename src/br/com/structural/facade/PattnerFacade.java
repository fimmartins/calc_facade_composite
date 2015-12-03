package br.com.structural.facade;

class IRRF {
	void f() {
	}

	void g() {
	}
}

class ICMS {
	void x() {
	}

	void y() {
	}
}

class ISS {
	void m() {
	}

	void n() {
	}
}

class CalculoImposto {
	int calcularImpostoSimples() {
		ICMS icms = new ICMS();
		IRRF irrf = new IRRF();
		ISS iss = new ISS();
		// return Integer(iss.m() + irrf.f() + icms.x());
		return 0;
	}
}

class FacadeImposto {
	
	ICMS icms = new ICMS();
	IRRF irrf = new IRRF();
	ISS iss = new ISS();
	
	double calcularNotaFiscalEletronicaMG() {
		return 0.0;
	}

	double calcularImpostoSimples() {
		return 0.0;
	}
}

public class PattnerFacade {
	
	public static void main(String[] args) {
		FacadeImposto facadeImposto = new FacadeImposto();
		System.out.println(facadeImposto.calcularImpostoSimples());
		
		
	}

}
