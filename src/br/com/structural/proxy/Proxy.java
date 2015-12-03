package br.com.structural.proxy;

/**
 * Exemplo Image extraído da internte link:
 * https://en.wikipedia.org/wiki/Proxy_pattern#Java
 */
interface Image {
	public void displayImage();
}

// on System A
class RealImage implements Image {

	private String filename = null;

	/**
	 * Constructor
	 * 
	 * @param filename
	 */
	public RealImage(final String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	/**
	 * Loads the image from the disk
	 */
	private void loadImageFromDisk() {
		System.out.println("Loading   " + filename);
	}

	/**
	 * Displays the image
	 */
	public void displayImage() {
		System.out.println("Displaying " + filename);
	}

}

// on System B
class ProxyImage implements Image {

	private RealImage image = null;
	private String filename = null;

	/**
	 * Constructor
	 * 
	 * @param filename
	 */
	public ProxyImage(final String filename) {
		this.filename = filename;
	}

	/**
	 * Displays the image
	 */
	public void displayImage() {
		if (image == null) {
			image = new RealImage(filename);
		}
		image.displayImage();
	}

}

/**
 * Autor: Felipe Augusto Tércio
 */

public class Proxy implements ContratoServico {
	// Obrigatoriamente deve ter a variavel do servico original
	// Obrigatoriamente o proxy tem que adicionar outros comportamentos.
	Servico servico = new Servico();

	public void f1() {
		// Faz algo .. Auditoria
		servico.f1();
	} 

	public void f2() {
		// Faz algo .. Auditoria
		servico.f2();
	}

	public void f3() {
		// Faz algo .. Auditoria
		servico.f3();
	}

}

interface ContratoServico {

	void f1();

	void f2();

	void f3();
}

class Servico implements ContratoServico {

	public void f1() {
		System.out.println("f1");
	}

	public void f2() {
		System.out.println("f2");
	}

	public void f3() {
		System.out.println("f3");
	}
}

class Cliente {
	public static void main(String[] args) {
		// Serviço antigo
		// Servico servico = new Servico();
		// servico.f1();
		Proxy servicoProxy = new Proxy();
		servicoProxy.f1();

		// Image
		final Image IMAGE1 = new ProxyImage("HiRes_10MB_Photo1");
		final Image IMAGE2 = new ProxyImage("HiRes_10MB_Photo2");

		IMAGE1.displayImage(); // loading necessary
		IMAGE1.displayImage(); // loading unnecessary
		IMAGE2.displayImage(); // loading necessary
		IMAGE2.displayImage(); // loading unnecessary
		IMAGE1.displayImage(); // loading unnecessaryf
	}
}
