package deportistas.tdd;

import java.util.*;

import deportistas.tdd.enumeradores.TipoDeEvento;
import deportistas.tdd.interfaces.ICiclista;
import deportistas.tdd.interfaces.INadador;
import deportistas.tdd.interfaces.IPedestrismo;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<String, Evento> competencias;
	private Evento evento;
	
	public Club(String nombre) {
		this.setNombre(nombre);
		competencias  = new HashMap<>();
		socios = new HashSet<>();
	}
	
	public void agregarDeportista(Deportista deportista) {
		socios.add(deportista);
	}
	
	public Integer getCantidadSocios() {
		return socios.size();
	}

	public void crearEvento(TipoDeEvento eventoACrear, String nombreEvento ) {
		this.evento = new Evento (eventoACrear);
		competencias.put(nombreEvento, evento);
	}

	public Boolean inscribirEnEvento(String nombreEvento, Deportista deportista) throws NoEstaPreparado {
		Evento eventoEncontrado=buscarTipoDeEvento(nombreEvento);
		if (eventoEncontrado!= null){
		switch(eventoEncontrado.getTipo()) {
		case CARRERA_NATACION_EN_AGUAS_ABIERTAS:
			if(deportista instanceof INadador) {
				evento.agregarParticipante(deportista.getNumeroDeSocio(), deportista);
				return true;
			} else throw new NoEstaPreparado();
			
		case CARRERA_42K:
			if(deportista instanceof IPedestrismo){
				evento.agregarParticipante(deportista.getNumeroDeSocio(), deportista);
				return true;
			}else throw new NoEstaPreparado();
	
		case TRIATLON_IRONMAN:
			if(deportista instanceof INadador&&deportista instanceof IPedestrismo&&deportista instanceof ICiclista) {
				evento.agregarParticipante(deportista.getNumeroDeSocio(), deportista);
				return true;
			}else throw new NoEstaPreparado();

		default:
			return false;
		 }
		} return false;
	}
	
	private Evento buscarTipoDeEvento(String nombreEvento) {
		for (Map.Entry<String, Evento> eventos : competencias.entrySet()) {
			String nombreEventoEncontrado=eventos.getKey();
			Evento valorEventoEncontrado=eventos.getValue();
			if(nombreEvento.equals(nombreEventoEncontrado)){
				return valorEventoEncontrado;
			}
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}