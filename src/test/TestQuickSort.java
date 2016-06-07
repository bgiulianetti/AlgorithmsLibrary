package test;

import java.util.Arrays;

import dyc.QuickSort;

public class TestQuickSort {

	public static void main(String[] args) {

		QuickSort q = new QuickSort();
		
		System.out.println("QuickSort");
		System.out.println();
		System.out.println("caso 1");
		int[] valores = { 3, 9, 7, 6, 2, 1, 8, 5, 4 };
						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores));
		
		try {
			q.quickSort(valores);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenados por QuickSort");
		System.out.println(Arrays.toString(valores));
		
		System.out.println();
		System.out.println("caso 2");
		int[] valores1 = { 3, 9, 17, 6, 12, 1, 18, 5, 4, 2, 10, 7, 11, 19, 8, 20, 13, 16  };
						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores1));
		
		try {
			q.quickSort(valores1);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenados por QuickSort");
		System.out.println(Arrays.toString(valores1));

	}

}
