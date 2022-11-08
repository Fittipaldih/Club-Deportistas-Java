package deportistas.tdd;

public class Deportista {
	private Integer numSocio;
	private String nombre;
	
	
	public Deportista (int numSocio, String nombre){
		this.numSocio = numSocio;
		this.nombre = nombre;
	}
	
	public Integer getNumeroDeSocio() {
		return this.numSocio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numSocio == null) ? 0 : numSocio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Deportista other = (Deportista) obj;
		if (numSocio == null) {
			if (other.numSocio != null)
				return false;
		} else if (!numSocio.equals(other.numSocio))
			return false;
		return true;
	}
		
}

