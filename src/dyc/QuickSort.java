package dyc;

public class QuickSort {
	
	public QuickSort(){};
	
	public int[] quickSort(int valores[]) throws Exception {
	    //caso base 
		if (valores.length == 0) {
			System.out.println("caso base");
			return valores;
		}
		//vectores para los menores y mayores al pivot
		int mayores_piv[] = new int[valores.length ];
	    int menores_piv[] = new int[valores.length ];  
	    int pivot = valores[0];
	    int j = 0;
	    int k = 0;
        for ( int i = 1; i<(valores.length); i++){
        	if (valores[i]>pivot){
        		//mover las mayores al vector de mayores al pivot 
        		mayores_piv[j] = valores[i];
        		j++;
        	}
        	else{
        		//mover los menores al vector de menores al pivot
               	 menores_piv[k] = valores[i];	
        		 k++;
        	}
        	
        }
        //me quedo solo con las posiciones q me sirven
        int menores_piv_aux[] = new int[ k ];
        for ( int i = 0; i<k; i++){
        	menores_piv_aux[i] = menores_piv[i];
        }
        //actualizo el vector de menores para que tenga el tamaño justo
        menores_piv = menores_piv_aux;
        //me quedo solo con las posiciones q me sirven       
        int mayores_piv_aux[] = new int[ j ];
        for ( int i = 0; i<j; i++){
        	mayores_piv_aux[i] = mayores_piv[i];
        }
        //actualizo el vector de menores para que tenga el tamaño justo  
        mayores_piv = mayores_piv_aux;
        System.out.println("division");          
		mayores_piv = quickSort(mayores_piv);
		System.out.println("division");
		menores_piv = quickSort(menores_piv);
		int res[] = new int[k+j+ 1];//creo el vector que devuelve la funcion
		//concateno el vector de menore + el pivot + el vector de mayores
		System.out.println("union");
		System.arraycopy(menores_piv, 0, res, 0, k);
		res[k] = pivot;
		System.arraycopy(mayores_piv, 0, res, k+1, j);
		return res;
	}
	

	 
	
	

}
