package cursojava.lenguaje.basico.tipos.clases;

public abstract class GestorDeVehiculos {
	
	public static boolean realizarMatriculacion(Vehiculo v) {
		
		if(v.comprobarEstadoTecnico()) {
			v.matricular("MATRICULA");
			return true;
		}
		
		return false;
	}

}
