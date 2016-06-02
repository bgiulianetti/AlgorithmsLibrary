package implementaciones;



public class ConjuntoDinamico  {

	class Nodo{
		int valor;
		Nodo sig;
	}
	
	Nodo c;
	 
	public void inicializarConjunto() {
		c=null;
	}

	 
	public boolean conjuntoVacio() {
		return (c==null);
	}

	 
	public void agregar(int x) {
		if(!this.pertenece(x))
		{
			Nodo aux = new Nodo();
			aux.valor=x;
			aux.sig=c;
			c=aux;
		}
	}

	 
	public int elegir() {
		return c.valor;
	}

	 
	public void sacar(int x) {
		
		// si tiene elementos
		if(c!=null)
		{
			if(c.valor==x)
			{
				c=c.sig;
			}
			else
			{
				Nodo aux = c;
				while(aux.sig!=null && aux.sig.valor!=x)
				{
					aux=aux.sig;
				}
				if(aux.sig!=null)
				{
					aux.sig=aux.sig.sig;
				}
			}
		}
	}

	 
	public boolean pertenece(int x) {
		
		Nodo aux = c;
		while( (aux!=null) && (aux.valor!=x))
		{
			aux=aux.sig;
		}
		return (aux!=null);
	}


	public void mostrarConjunto(ConjuntoDinamico c) {
		if(c.conjuntoVacio())
		{
			System.out.println("Conjunto vacio");
		}
		else
		{
		while(!c.conjuntoVacio()){			
			int x = c.elegir();
			System.out.println(x);
			c.sacar(x);
		}		
		}
	}

}
