package test;

import java.util.Arrays;

import dyc.BusquedaBinaria;

public class TestBusquedaBinaria {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		BusquedaBinaria b = new BusquedaBinaria();
		
		System.out.println("Búsqueda Binaria");
		System.out.println();
		System.out.println("Caso 1");
		//int[] valores = { 3,6,9,1,7,2,5,8,4};
		int[] valores = { 1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(valores));
        int longitud = 9;
        int valor = 3;
        boolean flag = false;
        System.out.println("Busco: "+ valor);
		try {
			flag = b.busquedaBinaria(valores, 0, longitud-1, valor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("la busqueda dio: " +flag);
		
		
		
		System.out.println();
		System.out.println("Caso 2");
		//int[] valores = { 3,6,9,1,7,2,5,8,4};
		int[] valores1 = { 1,3,4,5,6,7,8,9,10,12,15,16,17,20,25,29,30,31};
		System.out.println(Arrays.toString(valores1));
        longitud = 18;
        valor = 4;
        System.out.println("Busco: "+ valor);
        flag = false;
        try {
			flag = b.busquedaBinaria(valores1, 0, longitud-1, valor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("la busqueda dio: " +flag);
		

		
		
	}

}
