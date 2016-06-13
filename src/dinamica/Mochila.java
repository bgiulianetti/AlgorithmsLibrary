package dinamica;

import java.util.*;  
 
public class Mochila { 
	
    private List<Elemento> listaElementos; 
    private int pesoMáximo; 
     
    public Mochila(){ 
        listaElementos = new LinkedList<Elemento>(); 
        pesoMáximo = 0; 
    } 
     
    public Mochila(List<Elemento> listaElementos, int pesoMáximo){ 
        this.listaElementos = new LinkedList<Elemento>(listaElementos);  
        this.pesoMáximo = pesoMáximo; 
    } 
     
    public List<Elemento> resolver(){ 
        List<Elemento> res  = new LinkedList<Elemento>(); 
//		Collections.sort(listaElementos); 
//        System.out.println(listaElementos); 
        int totalPeso = 0; 
        while(!listaElementos.isEmpty() && totalPeso < pesoMáximo){ 
            Elemento o = listaElementos.get(0); 
            if(totalPeso + o.peso <= pesoMáximo){ 
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
        String res = "Peso máximo: " + pesoMáximo + "\nLista de Elementos: "; 
        res += listaElementos.toString(); 
         
        return res; 
    } 
} 
