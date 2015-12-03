package br.com.structural.proxy;
/**
 * Este exemplo explica como é realizado o processo de comunicação entre o cliente  e servidor via WSDL ou EJB ...
 * STUB: instanciado no lado do cliente
 * SKELETON: Instanciado no lado do Stub para comunicar.
 */
class Stub implements Contract {

	Skeleton service = new Skeleton();

	public void imprimirPDF() {
		service.imprimirPDF();

	}

	public void recuperarDados() {
		service.recuperarDados();

	}

}

class Skeleton implements Contract {

	Service service = new Service();

	public void imprimirPDF() {
		service.imprimirPDF();

	}

	public void recuperarDados() {
		service.recuperarDados();

	}

}

class Service implements Contract {

	public void imprimirPDF() {
		System.out.println("Imprime PDF");
	}

	public void recuperarDados() {
		System.out.println("Retorno de dados");
	}

}

public class RemoteProxy {
	
	public static void main(String[] args) {
		Stub remoteService = new Stub();
		remoteService.recuperarDados();
		remoteService.imprimirPDF();
	}
	
}
