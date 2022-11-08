package deportistas.tdd;

public class NoEstaPreparado extends Exception {

	
	public NoEstaPreparado (){
	}
	
	public NoEstaPreparado (String mensaje){
		super(mensaje);
	}
}
