package backtracking;

import java.util.*;

public class MochilaBt {
	
    Vector<ElementoBt> almacen = new Vector<ElementoBt>();
    Vector<ElementoBt> mochila = new Vector<ElementoBt>();
    Vector<ElementoBt> tmpMochila = new Vector<ElementoBt>();   
    final double pesoMaximo;
        
    
    public MochilaBt(int pm) {    	
        pesoMaximo = pm;
        cargarDatos();
    }
 
    
    public void cargarDatos() {
    	
        almacen.add(new ElementoBt("TV",        300, 15));
        almacen.add(new ElementoBt("PS3",       100,  3));
        almacen.add(new ElementoBt("Libro Java", 10,  1));
        almacen.add(new ElementoBt("DVD Player",  5,  0.5));
        almacen.add(new ElementoBt("Blu-Ray",    50,  0.5));
        almacen.add(new ElementoBt("Balon",      30,  0.5));
        almacen.add(new ElementoBt("iPod",      150,  1));
        almacen.add(new ElementoBt("Printer",    20,  4));
        almacen.add(new ElementoBt("VideoBeam", 200,  4));
        almacen.add(new ElementoBt("LapTop",     20,  3));
        almacen.add(new ElementoBt("iPad",      150,  2));
        almacen.add(new ElementoBt("PC",        100,  5));
        almacen.add(new ElementoBt("BlackBerry",150,  0.5));
   }
 
    
     public void mostrarMochila() {
    	 
        double pesoMochila=0;
        double valorMochila=0;
        System.out.println();
        
        for(ElementoBt e: mochila) {
            System.out.println(e);
            pesoMochila+=e.peso;
            valorMochila+=e.valor;
        }
        
        System.out.println("------");
        System.out.printf("Peso  = %,12.2f %n", pesoMochila);
        System.out.printf("Valor = %,12.2f %n", valorMochila);
    }
 
     
  // Solución por backtracking
     
     public void resolverProblemaBT(int posicion, double valorMaximo) {
    	 
         double  pesoMochila=getPeso(tmpMochila);    // peso de la solucion temporal
         double valorMochila=getValor(tmpMochila);   // valor de la solucion temporal
  
         if( posicion>=almacen.size() ) {            // si ya se tuvieron en cuenta todos los elementos
             if(valorMochila>valorMaximo) {          // si el valor es mayor que el máximo anterior
                 valorMaximo=valorMochila;           // se actualiza el valor mayor
                 mochila.clear();
                 mochila.addAll(tmpMochila);
             }
             return;
         }
         ElementoBt e = almacen.get(posicion);
         // Si el elemento se puede agregar, se envía a la mochila temporal
         if(pesoMochila + e.peso <= pesoMaximo) {
                 tmpMochila.add(e);                  // Se agrega a la mochila temporal
                 resolverProblemaBT(posicion+1, valorMaximo);     // se revisa para el siguiente elemento
                 tmpMochila.remove(e);               // Se retira el elemento
         }
         // Si no se pudo agregar, o ya se agregó y se retiró, se revisa para el siguiente
         resolverProblemaBT(posicion+1, valorMaximo);
     }
  
     
     double getPeso(List<ElementoBt> tmp) {
    	 
         double respuesta=0;
         for(ElementoBt e: tmp) respuesta+=e.peso;
         return respuesta;
     }
     
  
     double getValor(List<ElementoBt> tmp) {
    	 
         double respuesta=0;
         for(ElementoBt e: tmp) respuesta+=e.valor;
         return respuesta;
     }
}