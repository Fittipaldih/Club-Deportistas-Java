package deportistas.tdd.interfaces;

import deportistas.tdd.enumeradores.TipoDeBicicleta;

public interface ICiclista {
	public TipoDeBicicleta getTipoDeBicicleta();
	public void setCantidadDeKilometrosEntrenados(Integer km);
	public Integer getCantidadDeKilometrosEntrenados();
}
