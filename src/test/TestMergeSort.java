package test;

import java.util.Arrays;

import dyc.MergeSort;

public class TestMergeSort {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		MergeSort m = new MergeSort();
		
		System.out.println("MergeSort");
		System.out.println();
		System.out.println("caso 1");
		int[] valores = { 3, 7, 8, 2, 1, 5, 9, 6, 4 };
		int[] orden= new int[valores.length];						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores));
		
		try {
			
			orden=m.mergeSort(valores);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenados por MergeSort");
		System.out.println(Arrays.toString(orden));

		
		System.out.println("caso 2");
		int[] valores1 = { 3, 7, 8, 5, 9, 6, 10, 4, 20, 2, 12, 1, 14, 30, 16, 22, 13, 19 };
		int[] orden1= new int[valores1.length];						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores1));
		
		try {
			
			orden1=m.mergeSort(valores1);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenados por MergeSort");
		System.out.println(Arrays.toString(orden1));

	}

}
