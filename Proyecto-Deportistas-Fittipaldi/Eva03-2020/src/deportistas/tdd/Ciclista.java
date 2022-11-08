package deportistas.tdd;

import deportistas.tdd.enumeradores.TipoDeBicicleta;
import deportistas.tdd.interfaces.ICiclista;

public class Ciclista extends Deportista implements ICiclista{

	private Integer cantidadKmEntrenados;
	private TipoDeBicicleta tipo;
	
	public Ciclista(int numSocio, String nombre, TipoDeBicicleta tipo) {
		super (numSocio, nombre);
		this.tipo=tipo;
		this.cantidadKmEntrenados = 0;
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return this.tipo;
	}

	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.cantidadKmEntrenados = km;
		
	}

	public Integer getCantidadDeKilometrosEntrenados() {
		return this.cantidadKmEntrenados;
		
	}

}
