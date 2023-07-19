package cursojava.lenguaje.basico.pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cursojava.lenguaje.basico.excepciones.ServicioGestionClientes;
import cursojava.lenguaje.basico.excepciones.ServicioGestionClientesException;
import cursojava.lenguaje.basico.tipos.clases.Cliente;
import cursojava.lenguaje.basico.tipos.enumeraciones.TipoError;

public class ProbarEmpleoDeExcepciones {

	public static void main(String[] args) {

		// modeloBasico();

		// empleoDeMultiCatch();

		// empleoDeAutoclosable();
		
		try {
			
			ServicioGestionClientes servicio = new ServicioGestionClientes();
			
			servicio.alta(
				//new Cliente("Pedro", "García11111111111111111111")
				new Cliente("Pedro4", "García")
			);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			if (e instanceof ServicioGestionClientesException) {
				ServicioGestionClientesException ex = (ServicioGestionClientesException) e;
				
				System.out.println(ex.getDatos());
				
				if(ex.getDatos() == TipoError.GESTION_CLIENTES_NOMBRE_INCORRECTO) {
					System.out.println("Nombre: " + ex.getInfo());
				}
			}
		}

	}

	public static void empleoDeAutoclosable() throws FileNotFoundException {
		
		FileInputStream fichero = new FileInputStream("prueba.txt");
		FileOutputStream resultado = new FileOutputStream("datos.txt");

		try (
				
//			FileInputStream fichero = new FileInputStream("prueba.txt");
//			FileOutputStream resultado = new FileOutputStream("datos.txt");
			
			// Permite la creación de los recursos fuera del try
			fichero;	
			resultado;				
		) 
		{

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void empleoDeMultiCatch() {
		FileInputStream fichero = null;

		try {

			fichero = new FileInputStream("prueba.txt");

		} catch (FileNotFoundException | SecurityException e) {

			// Si queremos saber que tipo de excepción es hay que comprobar
			if (e instanceof FileNotFoundException) {
				FileNotFoundException ex = (FileNotFoundException) e;
			}

			System.err.println("Error capturado");
			System.err.println(e);

		} catch (Exception e) {

			String mensaje = e.getMessage();
			e.printStackTrace();
			Throwable problemaPrevio = e.getCause();
		} finally {

			try {

				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public static void modeloBasico() {

		FileInputStream fichero = null;

		try {

			fichero = new FileInputStream("prueba.txt");

		} catch (FileNotFoundException e) {

			System.err.println("Error capturado");
			System.err.println(e);

		} catch (SecurityException e) {

			System.err.println("Error capturado");
			System.err.println(e);

		} catch (Exception e) {

			String mensaje = e.getMessage();
			e.printStackTrace();
			Throwable problemaPrevio = e.getCause();
		} finally {

			try {

				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

}
