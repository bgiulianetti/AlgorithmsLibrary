package dinamica;

import java.util.*;  
 
public class Mochila { 
	
    private List<Elemento> listaElementos; 
    private int pesoM�ximo; 
     
    public Mochila(){ 
        listaElementos = new LinkedList<Elemento>(); 
        pesoM�ximo = 0; 
    } 
     
    public Mochila(List<Elemento> listaElementos, int pesoM�ximo){ 
        this.listaElementos = new LinkedList<Elemento>(listaElementos);  
        this.pesoM�ximo = pesoM�ximo; 
    } 
     
    public List<Elemento> resolver(){ 
        List<Elemento> res  = new LinkedList<Elemento>(); 
//		Collections.sort(listaElementos); 
//        System.out.println(listaElementos); 
        int totalPeso = 0; 
        while(!listaElementos.isEmpty() && totalPeso < pesoM�ximo){ 
            Elemento o = listaElementos.get(0); 
            if(totalPeso + o.peso <= pesoM�ximo){ 
                res.add(o); 
                listaElementos.remove(0); 
                totalPeso += o.peso; 
            }else{ 
                listaElementos.remove(0); 
            } 
        } 
         
        return res; 
    } 
     
    public String toString(){ 
        String res = "Peso m�ximo: " + pesoM�ximo + "\nLista de Elementos: "; 
        res += listaElementos.toString(); 
         
        return res; 
    } 
} 
