package cursojava.lenguaje.basico.pruebas;

import java.lang.annotation.Annotation;

import cursojava.lenguaje.basico.tipos.anotaciones.ControlCalidad;
import cursojava.lenguaje.basico.tipos.clases.Cliente;

public class ProbarAnotaciones {
	
	public static void main(String[] args) throws ClassNotFoundException {		
		
		// Class claseCliente = Class.forName("cursojava.lenguaje.basico.tipos.clases.Cliente");
		
		Class claseCliente = new Cliente("Luis", "Pérez").getClass();		
		
		for (Annotation annotation : claseCliente.getAnnotations()) {
			
			if (annotation instanceof ControlCalidad) {
				ControlCalidad control = (ControlCalidad) annotation;
				
				System.out.printf("Control calidad - versión: %s - pruebaok: %s%n", control.value(), control.testOk());
				
			}
			
		}
		
	}

}
