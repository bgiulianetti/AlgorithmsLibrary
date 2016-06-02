package greedy;

import implementaciones.ConjuntoDinamico;
import implementaciones.Grafo;

public class Dijkstra {

	public Dijkstra(){};
	
	public static Grafo dijkstra(Grafo g, int origen) throws Exception{
		
		int vertice, aux_vertice, mejor_vertice, mejor_distancia;
		
		Grafo distanciaMinimas = new Grafo();
		
		distanciaMinimas.InicializarGrafo();
		distanciaMinimas.AgregarVertice(origen);
		
		ConjuntoDinamico vertices = g.Vertices();
		vertices.sacar(origen);
		
		while(!vertices.conjuntoVacio()){
			
			vertice = vertices.elegir();
			vertices.sacar(vertice);
			distanciaMinimas.AgregarVertice(vertice);
			if(g.ExisteArista(origen, vertice)){
				distanciaMinimas.AgregarArista(origen, vertice, g.PesoArista(origen, vertice));
			}
		}
		
		ConjuntoDinamico pendientes = g.Vertices();
		pendientes.sacar(origen);
		
		ConjuntoDinamico aux_pendientes = new ConjuntoDinamico();
		aux_pendientes.inicializarConjunto();
		
		while(!pendientes.conjuntoVacio()){
			
			mejor_distancia = 0;
			mejor_vertice = 0;
			
			while(!pendientes.conjuntoVacio()){
				
				aux_vertice = pendientes.elegir();
				pendientes.sacar(aux_vertice);
				aux_pendientes.agregar(aux_vertice);
				
				if (( distanciaMinimas.ExisteArista (origen , aux_vertice ) 
						&& ( mejor_distancia == 0 
						|| (mejor_distancia > distanciaMinimas.PesoArista (origen , aux_vertice ))))){
					mejor_distancia = distanciaMinimas.PesoArista(origen, aux_vertice);
					mejor_vertice = aux_vertice;					
				}
				
			}
			
			vertice = mejor_vertice;
			
			if(vertice != 0 ){
				
				aux_pendientes.sacar(vertice);
				
				while(!aux_pendientes.conjuntoVacio()){
					
					aux_vertice = aux_pendientes.elegir();
					aux_pendientes.sacar(aux_vertice);
					pendientes.agregar(aux_vertice);
					
					if(g.ExisteArista(vertice, aux_vertice)){
						if(!distanciaMinimas.ExisteArista(origen, aux_vertice)){
							distanciaMinimas.AgregarArista(origen, aux_vertice, distanciaMinimas.PesoArista(origen, vertice)+g.PesoArista(vertice, aux_vertice));							
						}
						else{
							if(distanciaMinimas.PesoArista(origen, aux_vertice) > distanciaMinimas.PesoArista(origen, vertice)+g.PesoArista(vertice, aux_vertice)){
								distanciaMinimas.AgregarArista(origen, aux_vertice, distanciaMinimas.PesoArista(origen, vertice)+g.PesoArista(vertice, aux_vertice));
							}
						}
					}					
				}			
			}
			
		}
				
		return distanciaMinimas;						
	}
	
}
