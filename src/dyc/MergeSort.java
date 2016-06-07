package dyc;

public class MergeSort {

	public MergeSort(){};
	
	
	
	
	
	public static int[] mergeSort(int valores[]) throws Exception{

		int tamano; 
		tamano=valores.length;
		if (valores.length==1){
			System.out.println("Caso Base");
			return valores;
		}else{
			
			int mitad = tamano/ 2;
		    int parte1[] = new int[mitad];
		    int m1[] = new int[mitad];
		    int parte2[] = new int[tamano - mitad];
		    int m2[] = new int[tamano - mitad];
		    // Copio primera parte
		    for (int i = 0; i < mitad; i++)
		    {	parte1[i] = valores[i];
		    }
		    // Copio segunda parte
		    for (int i = mitad; i < tamano; i++)
		    {	parte2[i - mitad] = valores[i];
		    }	
			System.out.println("Division");
			m1=mergeSort(parte1);
			System.out.println("Division");
			m2=mergeSort(parte2);
			System.out.println("Union");
			return merge(m1,m2);
		}
	}
	public static int[] merge(int s1[], int s2[]) throws Exception{
		int i1=0;
		int i2=0;
		int i=0;
		int [] union= new int[s1.length+s2.length];
		while (i1<s1.length && i2<s2.length){
			if(s1[i1]<s2[i2]){
				union[i]=s1[i1];
				i1++;
			}else{
				union[i]=s2[i2];
				i2++;
			}
			i++;
		}
		if(i1<s1.length){
			while (i1<s1.length){
				union[i]=s1[i1];
				i1++;
				i++;
			}
		}
		if(i2<s2.length){
			while (i2<s2.length){
				union[i]=s2[i2];
				i2++;
				i++;
			}
		}
		return union;
	}
}
