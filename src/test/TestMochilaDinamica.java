package test;

import java.util.LinkedList;
import java.util.List;

import dinamica.Elemento;
import dinamica.Mochila;

public class TestMochilaDinamica {

	public static void main(String[] args) { 
		
        int peso = 10; 
        List<Elemento> listaElementos= new LinkedList<Elemento>(); 
        
        listaElementos.add(new Elemento(5,3)); 
        listaElementos.add(new Elemento(3,5)); 
        listaElementos.add(new Elemento(5,2)); 
        listaElementos.add(new Elemento(1,8)); 
        listaElementos.add(new Elemento(2,3)); 
        
        Mochila mochila = new Mochila(listaElementos, peso); 
        System.out.println(mochila.toString());
        System.out.println();
        
        List<Elemento> solucion = mochila.resolver(); 
        System.out.println("Solución: " + solucion.toString()); 
    } 

}
