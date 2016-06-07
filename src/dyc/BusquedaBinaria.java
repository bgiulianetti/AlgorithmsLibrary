package dyc;

public class BusquedaBinaria {
	
	
	public BusquedaBinaria(){};		
	
	public static boolean busquedaBinaria(int []valores, int inicio, int fin, int valor) throws Exception{
		
		
		if(valores[inicio]==valor){
			System.out.println("Caso Base");
			return true;
		}
		else{			
			int mitad = (inicio+fin)/2;
			System.out.println("Division");
			if(valor <= valores[mitad]){
				return busquedaBinaria(valores, inicio, mitad, valor);
			}else{
				return busquedaBinaria(valores, (mitad+1), fin, valor);
			}			
		}		
	}

}
