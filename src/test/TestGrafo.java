package test;

import implementaciones.*;

public class TestGrafo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Grafo g = new Grafo();
		g.InicializarGrafo();
		
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarVertice(5);
		
		g.AgregarArista(1, 2, 10);
		g.AgregarArista(2, 2, 5);
		g.AgregarArista(3, 2, 15);
		g.AgregarArista(4, 2, 20);
		g.AgregarArista(5, 2, 9);
		g.AgregarArista(1, 5, 7);
		g.AgregarArista(1, 4, 3);
		g.AgregarArista(1, 3, 11);
		g.AgregarArista(3, 3, 17);
		g.AgregarArista(4, 3, 21);
		
		g.gradovertice(g, 1);
		System.out.println("--------------------------------");
		g.verticemayorgrado(g);
		System.out.println("--------------------------------");
		g.aristasdevertice(g);
	}

}
