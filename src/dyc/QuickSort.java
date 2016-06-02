package dyc;

public class QuickSort {
	
	public int partition(int []valores, int izq, int der) throws Exception
	{
	      int i = izq, j = der;
	      int tmp;
	      int pivot = valores[(izq + der) / 2];
	     
	      while (i <= j) {
	            while (valores[i] < pivot)
	                  i++;
	            while (valores[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = valores[i];
	                  valores[i] = valores[j];
	                  valores[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public void quickSort(int []valores, int izq, int der) throws Exception {
	      int i = partition(valores, izq, der);
	      if (izq < i - 1)
	            quickSort(valores, izq, i - 1);
	      if (i < der)
	            quickSort(valores, i, der);
	}
	

}
