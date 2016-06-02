package test;

import java.util.Arrays;

import dyc.MergeSort;

public class TestMergeSort {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		MergeSort m = new MergeSort();
		
		int[] valores = { 3, 8, 7, 5, 2, 1, 9, 6, 4 };
        int longitud = 9;
						
		System.out.println("Valores sin ordenar");
		System.out.println(Arrays.toString(valores));
		
		try {
			m.mergeSort(valores, 0, longitud-1);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		System.out.println();
		System.out.println("Valores ordenado");
		System.out.println(Arrays.toString(valores));
		
	}

}
