package deportistas.tdd;

import deportistas.tdd.interfaces.INadador;

public class Nadador extends Deportista implements INadador{
	private String estiloPreferido;
	
	public Nadador(int numSocio, String nombre, String estiloPreferido) {
		super (numSocio, nombre);
		this.estiloPreferido = estiloPreferido; 
	}



	public String getEstiloPreferido() {
		
		return this.estiloPreferido;
	}

}
