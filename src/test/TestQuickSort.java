package test;

import java.util.Arrays;

import dyc.QuickSort;

public class TestQuickSort {

	public static void main(String[] args) {

		QuickSort q = new QuickSort();
		
		int[] valores = { 3, 8, 7, 5, 2, 1, 9, 6, 4 };
        int longitud = 9;
						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores));
		
		try {
			q.quickSort(valores, 0, longitud-1);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenado");
		System.out.println(Arrays.toString(valores));

	}

}
