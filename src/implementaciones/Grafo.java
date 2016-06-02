package implementaciones;




public class Grafo {
	
	class NodoGrafo{
		int nodo ;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	
	class NodoArista{
		int etiqueta;
		NodoArista sigArista;
		NodoGrafo nodoDestino;
	}
	
	NodoGrafo origen;
	
	public void InicializarGrafo() {
		origen = null;

	}

	public void AgregarVertice(int v) {
		//El vertice se inserta al inicio de la lista de nodos
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null ;
		aux.sigNodo = origen;
		origen = aux;
	}

	public void EliminarVertice(int v) {
		//Se recorre la lista de vértices para remover el nodo v
		//y las aristas con este vértice.
		//Distingue el caso que sea el primer nodo
		if (origen.nodo == v) 
			origen = origen.sigNodo;
		NodoGrafo aux = origen;
		while (aux != null){
		//remueve de aux todas las aristas hacia v
		this.EliminarAristaNodo(aux , v);
		if (aux.sigNodo!= null && aux.sigNodo.nodo == v)
			//Si el siguiente nodo de aux es v, lo elimina
			aux.sigNodo = aux.sigNodo.sigNodo;
		
		aux = aux. sigNodo;
		}
	}
	
	/*
	* Si en las aristas del nodo existe
	* una arista hacia v, la elimina
	*/
	private void EliminarAristaNodo(NodoGrafo nodo, int v){
		NodoArista aux = nodo.arista;
		if (aux != null ) {
		//Si la arista a eliminar es la primera en
		//la lista de nodos adyacentes
			if (aux.nodoDestino.nodo == v)
				nodo.arista = aux.sigArista;			
			else{
				while (aux.sigArista!= null && aux.sigArista.nodoDestino.nodo != v)
					aux = aux. sigArista;		
				if (aux.sigArista!=null) 
					//Quita la referencia a la arista hacia v
					aux.sigArista = aux.sigArista.sigArista;
			}
		}
	}

	/*
	* Para agregar una nueva arista al grafo , primero se deben
	* buscar los nodos entre los cuales se va agregar la arista ,
	* y luego se inserta sobre la lista de adyacentes del nodo
	* origen (en este caso nombrado como v1)
	*/
	public void AgregarArista(int v1, int v2, int peso) {
		NodoGrafo n1 = posicion(v1);
		NodoGrafo n2 = posicion(v2);
		//La nueva arista se inserta al inicio de la lista
		//de nodos adyacentes del nodo origen
		NodoArista aux = new NodoArista();
		aux.etiqueta = peso ;
		aux.nodoDestino = n2;
		aux.sigArista = n1. arista;
		n1.arista = aux;

	}
	
	private NodoGrafo posicion(int v){
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo !=v){
		aux = aux.sigNodo;
		}
		return aux ;
	}

	/*
	* Se elimina la arista que tiene como origen al vértice v1
	* y destino al vértice v2
	*/
	public void EliminarArista(int v1, int v2) {
		NodoGrafo n1 = posicion(v1);
		EliminarAristaNodo(n1 ,v2);

	}

	public boolean ExisteArista(int v1, int v2) {
		NodoGrafo n1 = posicion(v1);
		NodoArista aux = n1.arista;
		while (aux != null && aux.nodoDestino.nodo !=v2)
			aux = aux.sigArista;
		return (aux!=null);
	}

	public int PesoArista(int v1, int v2) {
		NodoGrafo n1 = posicion(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.nodo != v2)
			aux = aux.sigArista;			
		return aux.etiqueta;
	}

	public ConjuntoDinamico Vertices(){
		ConjuntoDinamico c = new ConjuntoDinamico();
		c.inicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null){
			c.agregar(aux.nodo);			
			aux = aux.sigNodo;
		}				
		return c;
	}
	
	/*
	public boolean existeVertice(int x){
		NodoGrafo aux = posicion(x);
		while( (aux!=null) && (aux.nodo!=x) )
		{
			aux=aux.sigNodo;
		}
		return (aux!=null);
	}
	
	public boolean grafoVacio(){
		return (origen==null);
	}
	
	public void mostrarGrafo(Grafo g){
		if(!g.grafoVacio()){
			
		}
	}
	*/
	
	// Algoritmo 1
	// Dado un Grafo, determinar si el Grafo es completo (true o false)
	// Un grado es completo <-> si todos sus vértices tienen una arista (estén conectados)
	
	public boolean completo(Grafo g){
		
		ConjuntoDinamico vertices = new ConjuntoDinamico();
		vertices.inicializarConjunto();		
		vertices = g.Vertices();
		boolean estaCompleto=true;
		
		while(!vertices.conjuntoVacio() && estaCompleto){
			int verticeAislado = vertices.elegir();
			
			ConjuntoDinamico verticesA = new ConjuntoDinamico();
			verticesA.inicializarConjunto();
			
			while(!verticesA.conjuntoVacio()){
				int aux = verticesA.elegir();
				if(!g.ExisteArista(verticeAislado, aux))
					estaCompleto=false;
				verticesA.sacar(aux);
			}
			vertices.sacar(verticeAislado);			
		}
		return estaCompleto;
	}
	
	// Algoritmo 2
	// Dado un Grafo g, determinar si tiene nodos aislados. Es aislado si no tiene aristas salientes ni entraste
	
	public boolean aislados(Grafo g){
		
		ConjuntoDinamico vertices = new ConjuntoDinamico();
		vertices.inicializarConjunto();
		ConjuntoDinamico posiblesVertices = new ConjuntoDinamico();
		posiblesVertices.inicializarConjunto();
		boolean estaAislado=false;
		
		vertices = g.Vertices();
		
		while(!vertices.conjuntoVacio()){
			int aux = vertices.elegir();
			//if(== null)
				posiblesVertices.agregar(aux);
		vertices.sacar(aux);
		
		
		}
		return estaAislado;
	}
	
	
	// Algoritmo 
	// TODO: recibe un Grafo G y devuelva el valor del vértice de mayor grado. 
	// El grado de un vértice es la cantidad de aristas entrantes menos la cantidad de aristas salientes
	
	// Algoritmo 
	// TODO: recibe un Grafo G y devuelve un ColaPrioridad que tenga el valor del nodo como cola de la prioridad 
	// y la prioridad sea el número de arista que posee ese nodo (tanto entraste como salientes)
	
	// Algoritmo 
	// TODO: - Recibimos un grafo y un vertice y decimos que grado tiene (aristas salientes - aristas entrantes)
	
	public void aristasdevertice(Grafo a) {
		ConjuntoDinamico aux = a.Vertices();
		ConjuntoDinamico aux2 = a.Vertices();
		ColaPrioridadDinamica auxcola= new ColaPrioridadDinamica();
		auxcola.inicializarColaPrioridad();
		
		while(!aux.conjuntoVacio()){
			int el=aux.elegir();
			int cantactual=0;
			
			while(!aux2.conjuntoVacio()){
				int elaux= aux2.elegir();
				
				if (el!=elaux){
					if (a.ExisteArista(el, elaux)==true){
						cantactual=cantactual+1;
					}
					if (a.ExisteArista(elaux, el)==true){
						cantactual=cantactual+1;
					}
				}
				aux2.sacar(elaux);
			}
			aux2 = a.Vertices();
			auxcola.acolarPrioridad(cantactual, el);
			aux.sacar(el);
		}
		
		System.out.println("Vertices	CantAristas");
		while (!auxcola.colaPrioridadVacia()){
			System.out.println("   "+ auxcola.prioridad()+"   		     "+ auxcola.primero());
			auxcola.desacolarPrioridad();
		}
	}
	
	
	public void gradovertice(Grafo a, int vertice) {
		
		int cantactual=0;
		ConjuntoDinamico aux2 = a.Vertices();
		
		while(!aux2.conjuntoVacio()){
			int verticeaux= aux2.elegir();
				
			if (vertice!=verticeaux){
				if (a.ExisteArista(vertice, verticeaux)==true){
					cantactual=cantactual+1;
				}
				if (a.ExisteArista(verticeaux, vertice)==true){
					cantactual=cantactual-1;
				}
			}
			aux2.sacar(verticeaux);
		}
		System.out.println("Grado del vertice " + vertice + ", de grado " + cantactual);
	}
	
	
	public void verticemayorgrado(Grafo a) {
		
		ConjuntoDinamico aux = a.Vertices();
		ConjuntoDinamico aux2 = a.Vertices();
		int arfinal=0;
		int cantfinal=0;
		
		while(!aux.conjuntoVacio()){
			int el=aux.elegir();
			int cantactual=0;
			
			while(!aux2.conjuntoVacio()){
				int elaux= aux2.elegir();
				
				if (el!=elaux){
					if (a.ExisteArista(el, elaux)==true){
						cantactual=cantactual+1;
					}
					if (a.ExisteArista(elaux, el)==true){
						cantactual=cantactual-1;
					}
				}
				aux2.sacar(elaux);
				
				if (cantactual>cantfinal){
					cantfinal=cantactual;
					arfinal=el;
				}
			}
			aux2 = a.Vertices();
			aux.sacar(el);
		}
		System.out.println("Vertice con mayor grado: " + arfinal + ", de grado " + cantfinal);
	}
	
}
