package deportistas.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import deportistas.tdd.enumeradores.EstiloPreferidoNadador;
import deportistas.tdd.enumeradores.TipoDeBicicleta;
import deportistas.tdd.enumeradores.TipoDeEvento;

public class TestClub {

	@Test
	public void queSePuedaCrearUnNadador() {
		Nadador nuevo = new Nadador(1, "Camila", EstiloPreferidoNadador.CROLL);

		assertEquals(EstiloPreferidoNadador.CROLL, nuevo.getEstiloPreferido());
		assertEquals((Integer) 1, nuevo.getNumeroDeSocio());
	}

	@Test
	public void queSePuedaCrearUnCorredor() {
		Corredor nuevo = new Corredor(2, "Carolina", 10000);
		nuevo.setCantidadDeKilometrosEntrenados(50000);

		assertEquals((Integer) 10000, nuevo.getDistanciaPreferida());
		assertEquals((Integer) 50000, nuevo.getCantidadDeKilometrosEntrenados());
		assertEquals((Integer) 2, nuevo.getNumeroDeSocio());
	}

	@Test
	public void queSePuedaCrearUnCiclista() {
		Ciclista nuevo = new Ciclista(3, "Enzo", TipoDeBicicleta.BMX);

		assertEquals(TipoDeBicicleta.BMX, nuevo.getTipoDeBicicleta());
		assertEquals((Integer) 3, nuevo.getNumeroDeSocio());
	}

	@Test
	public void queSePuedaCrearUnTriatleta() {
		Triatleta nuevo = new Triatleta(4, "Luna", TipoDeEvento.TRIATLON_OLIMPICO, TipoDeBicicleta.TRIA, EstiloPreferidoNadador.ESPALDA);
		assertEquals((Integer) 0, nuevo.getDistanciaPreferida());
		assertEquals(TipoDeBicicleta.TRIA, nuevo.getTipoDeBicicleta());
		assertEquals((Integer) 4, nuevo.getNumeroDeSocio());
	}

	@Test
	public void queSePuedanIncorporarDistintosDeportistas() {
		// El n�mero de socio no se puede repetir
		Club actual = new Club("CARP");

		actual.agregarDeportista(new Corredor(1000, "Camila", 42000));
		actual.agregarDeportista(new Corredor(1001, "Natalia", 5000));
		actual.agregarDeportista(new Corredor(1002, "Jorge", 21000));
		actual.agregarDeportista(new Nadador(1003, "Lucrecia", EstiloPreferidoNadador.PECHO));
		actual.agregarDeportista(new Triatleta(1004, "Tamara", TipoDeEvento.TRIATLON_OLIMPICO, TipoDeBicicleta.RUTA, EstiloPreferidoNadador.CROLL));
		actual.agregarDeportista(new Ciclista(1005, "Alberto", TipoDeBicicleta.MOUNTAIN));
		actual.agregarDeportista(new Ciclista(1006, "Domingo", TipoDeBicicleta.BMX));
		actual.agregarDeportista(new Corredor(1007, "Luciana", 10000));
		actual.agregarDeportista(new Nadador(1008, "Luna", EstiloPreferidoNadador.CROLL));
		actual.agregarDeportista(new Nadador(1009, "Victor", EstiloPreferidoNadador.MARIPOSA));
		actual.agregarDeportista(new Triatleta(1004, "Cecilia", TipoDeEvento.TRIATLON_IRONMAN, TipoDeBicicleta.TRIA, EstiloPreferidoNadador.ESPALDA));

		assertEquals((Integer) 10, actual.getCantidadSocios());
	}

	@Test(expected = NoEstaPreparado.class)
	public void queUnCorredorNoSePuedaInscribirEnUnaCarreraDeNatacion() throws NoEstaPreparado {
		// En las carreras de nataci�n s�lo pueden inscribirse los que sean INadador
		Deportista celeste = new Corredor(1000, "Celeste", 10000);
		Club actual = new Club("Sitas");
		actual.agregarDeportista(celeste);
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Maraton de aguas abiertas");

		assertFalse(actual.inscribirEnEvento("Maraton de aguas abiertas", celeste));
	}

	@Test(expected = NoEstaPreparado.class)
	public void queUnCorredorNoSePuedaInscribirEnUnTriatlon() throws NoEstaPreparado {
		// En los triatlones s�lo pueden inscribirse los que sean INadador & ICiclista
		Deportista celeste = new Corredor(1000, "Celeste", 10000);
		Club actual = new Club("Sitas");

		actual.crearEvento(TipoDeEvento.TRIATLON_IRONMAN, "Triatlon Khona");

		assertFalse(actual.inscribirEnEvento("Triatlon Khona", celeste));
	}

	@Test
	public void queUnCorredorPuedaCorrerUnaMaraton() throws NoEstaPreparado {
		Deportista celeste = new Corredor(999, "Celeste", 42000);
		Club actual = new Club("Moron");

		((Corredor) celeste).setCantidadDeKilometrosEntrenados(100000);
		actual.crearEvento(TipoDeEvento.CARRERA_42K, "Maraton de New York");

		assertTrue(actual.inscribirEnEvento("Maraton de New York", celeste));
	}
}