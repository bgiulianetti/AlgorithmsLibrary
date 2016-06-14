package dinamica;

public class Elemento {
	
	int peso; 
    int valor; 
    double beneficio; 
     
    public Elemento(){    	
        this.peso = 0; 
        this.valor = 0; 
        this.beneficio = -1; 
    } 
     
    public Elemento(int peso, int valor){ 
        
    	this.peso = peso; 
        this.valor = valor; 
        
        if(peso > 0)
            beneficio = this.valor / this.peso; 
        else 
            beneficio = -1; 
        
    } 
 
    public int compareTo(Elemento o) { 
    	
        int res = 0;
        
        if	((this.beneficio > o.beneficio) || 
            ((this.beneficio == o.beneficio) && (this.peso < o.peso))){ 
            res = -1; 
        }else if((this.beneficio < o.beneficio) || 
                ((this.beneficio == o.beneficio) && (this.valor > o.valor)) || 
                ((this.beneficio == o.beneficio) && (this.valor == o.valor) && 
                        (this.peso < o.peso))){ 
            res = 1; 
        } 
        return res; 
    } 
     
    public String toString(){ 
    	
        return "(" + peso + " , " + valor + " , " + beneficio + ")"; 
    } 

}
