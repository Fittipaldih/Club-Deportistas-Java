package deportistas.tdd;

import deportistas.tdd.enumeradores.TipoDeBicicleta;
import deportistas.tdd.enumeradores.TipoDeEvento;
import deportistas.tdd.interfaces.*;

public class Triatleta extends Deportista implements ICiclista, INadador, IPedestrismo{

	private TipoDeBicicleta tipoBicicleta;
	private TipoDeEvento tipoEvento;
	private Integer distanciaPreferida;
	private Integer cantidadKmEntranados;
	
	public Triatleta(int numSocio, String nombre, TipoDeEvento tipoEvento, TipoDeBicicleta tria) {
		super (numSocio, nombre);
		this.tipoBicicleta = tria;
		this.tipoEvento = tipoEvento;
		this.distanciaPreferida =0;
		this.cantidadKmEntranados = 0;
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return this.tipoBicicleta;
	}

	public Integer getDistanciaPreferida() {
		return this.distanciaPreferida;
	}

	@Override
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.cantidadKmEntranados = km;
	}

	@Override
	public Integer getCantidadDeKilometrosEntrenados() {
		return this.cantidadKmEntranados;
	}

}
