package test;

import dyc.BusquedaBinaria;

public class TestBusquedaBinaria {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		BusquedaBinaria b = new BusquedaBinaria();
		
		int[] valores = { 3,6,9,1,7,2,5,8,4};
		//int[] valores = { 1,2,3,4,5,6,7,8,9};
        int longitud = 9;
        int valor = 7;
        boolean flag = false;
		
		try {
			flag = b.busquedaBinaria(valores, 0, longitud-1, valor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("El flag dio: " +flag);
		
//		int n = 9;
//		b.ordenarArreglo(valores, n);
//		b.muestra(valores);
		
		
	}

}
