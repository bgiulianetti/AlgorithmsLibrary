package test;

import greedy.Dijkstra;
import implementaciones.Grafo;

public class TestDijkstra 
{
	public static void main(String[] args) throws Exception 
	{
		Grafo grafo7Aristas = Dijkstra7Aristas();
		PrintGrafoDijkstra(grafo7Aristas, 7);
		
		Grafo grafo15Aristas = Dijkstra15Aristas();
		PrintGrafoDijkstra(grafo15Aristas, 15);
	}

	private static Grafo Dijkstra15Aristas()
	{
		Grafo g = new Grafo();
		g.InicializarGrafo();
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarVertice(5);
		g.AgregarVertice(6);
		g.AgregarVertice(7);
		g.AgregarVertice(8);
		
		g.AgregarArista(1, 2, 4);
		g.AgregarArista(1, 3, 12);
		g.AgregarArista(2, 3, 14);
		g.AgregarArista(2, 4, 9);
		g.AgregarArista(2, 5, 15);
		g.AgregarArista(3, 4, 3);
		g.AgregarArista(3, 5, 11);
		g.AgregarArista(4, 5, 20);
		g.AgregarArista(4, 6, 7);
		g.AgregarArista(4, 7, 1);
		g.AgregarArista(5, 6, 17);
		g.AgregarArista(5, 7, 5);
		g.AgregarArista(6, 7, 7);
		g.AgregarArista(6, 8, 19);
		g.AgregarArista(7, 8, 11);
		
		return g;
	}
	
	private static Grafo Dijkstra7Aristas()
	{
		Grafo g = new Grafo();
		g.InicializarGrafo();
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarVertice(5);
		g.AgregarVertice(6);

		
		g.AgregarArista(1, 2, 8);
		g.AgregarArista(1, 3, 2);
		g.AgregarArista(2, 4, 3);
		g.AgregarArista(2, 5, 2);
		g.AgregarArista(3, 5, 3);
		g.AgregarArista(4, 6, 4);
		g.AgregarArista(5, 6, 20);
		return g;
	}
	
	private static void PrintGrafoDijkstra(Grafo g, int cantidadAristas) throws Exception
	{
		System.out.println("Grafo con " + cantidadAristas + " aristas");
		System.out.println("====================");
		System.out.println();
		
		g.verticemayorgrado(g);
		System.out.println();
		g.aristasdevertice(g);
		
		System.out.println();
		System.out.println("Caminos mas cortos desde 1");
		System.out.println("--------------------------");
		System.out.println();
		String[] resultado = Dijkstra.dijkstra(g, 1);
		for(int i = 0; i < resultado.length ; i++)
		{
			System.out.println(resultado[i]);
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
}




