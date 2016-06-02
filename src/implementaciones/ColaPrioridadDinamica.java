package implementaciones;

public class ColaPrioridadDinamica {

	class NodoPrioridad{
		int valor;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	 
	public void inicializarColaPrioridad() {
		mayorPrioridad=null;
	}

	 
	public void acolarPrioridad(int x, int prioridad) {
		
		// se crea el nuevo nodo que voy a acolar
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.valor=x;
		nuevo.prioridad=prioridad;
		
		// si la cola está vacía      o bien tiene mayor prioridad que el primero hay que agregarlo al principio
		if(	mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) 
		{
			nuevo.sig=mayorPrioridad;
			mayorPrioridad=nuevo;
		}
		// sabemos que hay elementos
		else
		{
			NodoPrioridad aux = new NodoPrioridad();
			
			while(aux.sig!=null && aux.sig.prioridad>=prioridad)
			{
				aux=aux.sig;
			}
			nuevo.sig=aux.sig;
			aux.sig=nuevo;
		}
	}

	 
	public void desacolarPrioridad() {
		mayorPrioridad=mayorPrioridad.sig;
	}

	 
	public boolean colaPrioridadVacia() {
		return (mayorPrioridad==null);
	}

	 
	public int primero() {
		return mayorPrioridad.valor;
	}

	 
	public int prioridad() {
		return mayorPrioridad.prioridad;
	}

}
