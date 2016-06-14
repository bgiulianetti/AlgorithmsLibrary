package backtracking;

public class EspacioBt {
	
	public EspacioBt(){};

	public static int disco(int[] secuencia, int capacidad) throws Exception {

		int minimo = 2147483646;
		
		if(capacidad == 0){
			minimo = 0;
		}else{
			if(secuencia.length == 0 && capacidad > 0){
				minimo = capacidad;
			}else{
				if(secuencia.length > 0 && capacidad > 0){
					int[] b = eliminoElemento(secuencia);
					minimo = Math.min(disco(b, capacidad), disco(b, capacidad - secuencia[0]));
				}
			}
		}

		return minimo;
	}

	
	public static int[] eliminoElemento(int[] secuencia){

		int[] aux = new int[secuencia.length - 1];

		for (int i = 0; i < secuencia.length - 1; i++)
			aux[i] = secuencia[i + 1];		

		return aux;

	}

}
