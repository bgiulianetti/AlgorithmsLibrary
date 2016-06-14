package backtracking;

public class ElementoBt {

	String nombre;
    double valor;
    double peso;
    
    public ElementoBt(){};
            
    public ElementoBt(String nombre, double valor, double peso) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.peso = peso;
	}

	public String toString() {
        return String.format("%-15s %,12.2f %,12.2f", nombre, valor, peso);
    }
	
}
