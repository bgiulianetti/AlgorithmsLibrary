package dyc;

public class BusquedaBinaria {
	
	
	public BusquedaBinaria(){};		
	
	public static boolean busquedaBinaria(int []valores, int inicio, int fin, int valor) throws Exception{
		
		ordenarArreglo(valores, fin);
		
		if(valores[inicio]==valor){
			return true;
		}
		else{			
			int mitad = (inicio+fin)/2;
			if(valor <= valores[mitad]){
				return busquedaBinaria(valores, inicio, mitad, valor);
			}else{
				return busquedaBinaria(valores, (mitad+1), fin, valor);
			}			
		}		
	}
	
	public static int[] ordenarArreglo(int a[], int n) throws Exception
	{
  		int i,j,t;
 
		for(i=0;i<n-1;i++){
			for(j=0;j<n-1;j++){
				if(a[j]>a[j+1]){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
		return a;		
	}
	
	public static void muestra(int a[])
	{
		int n=a.length;
		
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");					
 
	}
	
}
