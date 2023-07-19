package cursojava.lenguaje.basico.tipos;

import cursojava.lenguaje.basico.tipos.clases.Cliente;
import cursojava.lenguaje.basico.tipos.clases.Coche;
import cursojava.lenguaje.basico.tipos.clases.GestorDeVehiculos;
import cursojava.lenguaje.basico.tipos.clases.Vehiculo;
import cursojava.lenguaje.basico.tipos.enumeraciones.Color;

public class EmpleoDeTiposEnJava {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		// referenciaDeTiposPrimitivos();
		
		// referenciaDeTiposObjeto();
		
		// Vehiculo unVehiculo = new Vehiculo("Acme", "M1000", 140.0, Color.AZUL);
		
		Vehiculo.plantillaVehiculo = "%10s|%10s|%20s|%6.0f|%10s";
		
		Coche unCoche = new Coche("Acme", "M1000", 140.0, Color.VERDE, 5);
		
		System.out.println(unCoche);
		
		GestorDeVehiculos.realizarMatriculacion(unCoche);
		
		System.out.println(unCoche);
		
		/////////////////////////////////////////////////////
		
		Cliente unCliente = new Cliente("Uno", "Cualquiera");
		
		unCliente.clone();
		
		
		
	}

	public static void referenciaDeTiposObjeto() {
		// Tipos refencia;
		
		// Se inicializan a null;
		// Permiten interactuar con la memoria asociada
		// La memoria referencia siempre es dinámica
		
		String unaCadena;		
		Cliente unCliente;
		
		// La referencia tiene asociada instancia
		unCliente = new Cliente("Luis", "García");
		
		System.out.println(unCliente);
		
		// Comparación de instancias
		
		Cliente otroCliente = new Cliente("Luis", "García");
		Cliente otroClienteMas = unCliente;
		
		// Comparando las referencias NO las instancias
		if(unCliente == otroCliente) {
			System.out.println("Son la misma referencia");
		}
		
		if(unCliente.equals(otroClienteMas)) {
			System.out.println("Son el mismo cliente");
		}
	}

	public static void referenciaDeTiposPrimitivos() {
		// Tipos primitivos
		// Vienen incorporados en el compilador Java
		// Se crean en la pila
		// Se copian por valor
		
		// Numéricos enteros (siempre con signo)
		
		byte enteroDe8bits = 100;
		short enteroDe16bits = 1000;
		int enteroDe32bits = 1;
		long enteroDe64bits = 1000000000000000000L;
		
		enteroDe8bits = (byte)enteroDe32bits;
		
		// Podemos emplear otras bases numéricas
		
		int baseDecimal = 120;
		int baseHexadecimal = 0xFF00FF00;
		int baseOctal = 012;
		int baseBinaria = 0b1111000011110000;
		
		// Coma flotante
		
		float decimal32bits = 1.0f;
		double decimal64bits = 1.0;
		
		// Booleano
		
		boolean hayDatos = false;
		
		// Caracter son UNICODE (16-bits)
		
		char unCaracter = '€';
		
		// Podemos emplear separadores para visualizar mejor el valor
		
		int diezMillones = 10_000_000;
		double milMillones = 1_000_000_000.0;
		int colorRojo = 0xff_00_00;
		int activarValidaciones = 0b1010_0111;
	}

}

class EmpleoTiposEnJava1 {
	
	public static void main(String[] args) {
		
	}

}
