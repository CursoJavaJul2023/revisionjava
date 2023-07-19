package cursojava.lenguaje.basico.pruebas;

import cursojava.lenguaje.basico.tipos.clases.Cliente;
import cursojava.lenguaje.basico.tipos.clases.Coche;
import cursojava.lenguaje.basico.tipos.clases.GestorCatalogo;
import cursojava.lenguaje.basico.tipos.enumeraciones.Color;
import cursojava.lenguaje.basico.tipos.interfaces.Catalogable;

public class ProbarGestorCatalogo {
	
	public static void main(String[] args) {
		
		GestorCatalogo gestorCatalogo = GestorCatalogo.getGestorCatalogo();
		
		Cliente unCliente = new Cliente("Juan", "García");
		Cliente otroCliente = new Cliente("Luis", "García");
		
		Coche unCoche = new Coche("Acme", "M1000", 140.0, Color.ROJO, 5);
		unCoche.matricular("AAA1000");
		
		gestorCatalogo.almacenar(unCliente);
		gestorCatalogo.almacenar(otroCliente);
		gestorCatalogo.almacenar(unCoche);
		
		Catalogable resultado1 = gestorCatalogo.buscarPorIdUnico(unCliente.getIdUnico());
		if (resultado1 instanceof Cliente) {
			Cliente elCliente = (Cliente) resultado1;
			System.out.println(elCliente);			
		}
		
		for (Catalogable resultado2 : gestorCatalogo.buscarPorPalabraClave("García")) {
			System.out.println(resultado2);
		}
		
		System.out.println("--------------------------------------------------------");
		
		for (Catalogable catalogable : gestorCatalogo) {
			System.out.println(catalogable);
		}
		
	}

}
