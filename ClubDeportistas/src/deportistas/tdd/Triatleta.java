package deportistas.tdd;

import deportistas.tdd.enumeradores.EstiloPreferidoNadador;
import deportistas.tdd.enumeradores.TipoDeBicicleta;
import deportistas.tdd.enumeradores.TipoDeEvento;
import deportistas.tdd.interfaces.*;

public class Triatleta extends Deportista implements ICiclista, INadador, IPedestrismo {

	private TipoDeBicicleta tipoBicicleta;
	private TipoDeEvento tipoEvento;
	private Integer distanciaPreferida;
	private Integer cantidadKmEntranados;
	private EstiloPreferidoNadador estiloPreferido;

	public Triatleta(int numSocio, String nombre, TipoDeEvento tipoEvento, TipoDeBicicleta tria, EstiloPreferidoNadador estilo) {
		super(numSocio, nombre);
		this.tipoBicicleta = tria;
		this.setTipoEvento(tipoEvento);
		this.distanciaPreferida = 0;
		this.cantidadKmEntranados = 0;
		this.setEstiloPreferido(estilo);
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

	public TipoDeEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoDeEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	@Override
	public EstiloPreferidoNadador getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferidoNadador estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}
}