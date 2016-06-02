package dyc;

public class QuickSort {
	
	public QuickSort(){};
	
	public void quickSort(int []valores, int izq, int der) throws Exception {
	      
		int i = partition(valores, izq, der);
	      
		if (izq < i - 1)
			quickSort(valores, izq, i - 1);  
		if (i < der)
			quickSort(valores, i, der);
	}
	
	public int partition(int[] valores, int izq, int der) throws Exception {
	
		int i = izq, j = der;
		int k;
		int pivot = valores[(izq + der) / 2];

		while (i <= j) {
			while (valores[i] < pivot)
				i++;
			while (valores[j] > pivot)
				j--;

			if (i <= j) {
				k = valores[i];
				valores[i] = valores[j];
				valores[j] = k;
				i++;
				j--;
			}
		}
		;

		return i;
	}
	 
	
	

}
