package test;

import dyc.BusquedaBinaria;

public class TestBusquedaBinaria {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		BusquedaBinaria b = new BusquedaBinaria();
		
		int[] valores = { 3, 8, 7, 5, 2, 1, 9, 6, 4 };
        int longitud = 9;
        int valor = 9;
        boolean flag = false;
		
		try {
			flag = b.busquedaBinaria(valores, 0, longitud-1, valor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("El flag dio: " +flag);
	}

}
