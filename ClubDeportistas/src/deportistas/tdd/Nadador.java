package deportistas.tdd;

import deportistas.tdd.enumeradores.EstiloPreferidoNadador;
import deportistas.tdd.interfaces.INadador;

public class Nadador extends Deportista implements INadador {
	private EstiloPreferidoNadador estiloPreferido;

	public Nadador(int numSocio, String nombre, EstiloPreferidoNadador estiloPreferido) {
		super(numSocio, nombre);
		this.estiloPreferido = estiloPreferido;
	}

	public EstiloPreferidoNadador getEstiloPreferido() {
		return this.estiloPreferido;
	}
}