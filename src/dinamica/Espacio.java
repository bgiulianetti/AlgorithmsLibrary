package dinamica;

import java.util.LinkedList;
import java.util.List;

public class Espacio {
			
	private List<Elemento> listaElementos;
	private int capacidad;
	
	public Espacio(){
		listaElementos = new LinkedList<Elemento>(listaElementos);
		setCapacidad(0);
	}
	
	public Espacio(List<Elemento> listaElementos, int capacidad){
		this.listaElementos = new LinkedList<Elemento>(listaElementos);
		this.setCapacidad(capacidad);
	}

	
	public static void espacio(int[] secuencia, int capacidad) throws Exception {

		int[][] matriz = new int[capacidad + 1][secuencia.length + 1];

		
		for (int i = 0; i <= capacidad; i++) 
			matriz[i][0] = i;
		

		for (int i = 0; i <= secuencia.length; i++) 
			matriz[0][i] = 0;

		
		for (int i = 1; i <= capacidad; i++) {
			for (int j = 1; j <= secuencia.length; j++) {
				if (i - secuencia[j - 1] < 0)
					matriz[i][j] = matriz[i][j - 1];
				else
					matriz[i][j] = Math.min(matriz[i][j - 1], matriz[i - secuencia[j - 1]][j - 1]);
			}
		}	
	}
	
	
	public void imprimirMatriz(int [][] matriz) {
		
        for(int f=0;f<matriz.length;f++) {
            for(int c=0;c<matriz[f].length;c++)
                System.out.print(matriz[f][c]+" ");            
            System.out.println();
        }
    }

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
