package dyc;

public class MergeSort {

	public MergeSort(){};
	

	public static void mergeSort(int valores[], int inicio, int fin) throws Exception{
		if(inicio<fin){
			int mitad = (inicio+fin)/2;
			mergeSort(valores, inicio, mitad);
			mergeSort(valores, (mitad+1), fin);
			merge(valores, inicio, (mitad+1), fin);
		}
	}
	
	public static void merge(int valores[], int inicio, int mitad, int fin) throws Exception{
		
		int [] resultado = new int[valores.length];
		int i, j, k, elementos;
		k = (mitad - 1);
		j = inicio;
		elementos = (fin-inicio+ 1);
		
		while ((inicio <= k) && (mitad <= fin)){		
			if (valores[inicio] <= valores[mitad]){
				resultado[j++] = valores[inicio++];
			}			
			else{
				resultado[j++] = valores[mitad++];
			}			
		}

		while (inicio <= k){
			resultado[j++] = valores[inicio++];
		}
			
		while (mitad <= fin){
			resultado[j++] = valores[mitad++];
		}
			
		for (i = 0; i < elementos; i++){		
			valores[fin] = resultado[fin];
			fin--;
		}
		
	}				 	 	 

	
}
