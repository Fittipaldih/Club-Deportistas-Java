package deportistas.tdd;
import deportistas.tdd.interfaces.IPedestrismo;

public class Corredor  extends Deportista implements IPedestrismo{
	Integer cantidadKmEntrenados, distanciaPreferida;
	
	public Corredor (int numSocio, String nombre, int distanciaPreferida){
		super(numSocio, nombre);
		this.cantidadKmEntrenados = 0;
		this.distanciaPreferida = distanciaPreferida;
		
	}
	
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.cantidadKmEntrenados = km;
	}

	public Integer getCantidadDeKilometrosEntrenados() {
		return this.cantidadKmEntrenados;
	}

	public Integer getDistanciaPreferida() {
		return this.distanciaPreferida;
	}


}
