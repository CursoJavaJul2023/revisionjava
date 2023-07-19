package cursojava.funcionalidad.entradaysalida;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import cursojava.lenguaje.basico.tipos.clases.Cliente;

public class EmpleoBasicoDeEntradaYSalida {
	
	public static void main(String[] args) {
		
		// empleoFlujosBinarios();
		
		// empleoFlujosTexto();
		
		
	}

	public static void empleoFlujosTexto() {
		try (
//				FileWriter ficheroTexto = new FileWriter(
//						"datos.csv", 
//						Charset.forName("UTF-8")
//						// Charset.forName("ISO-8859-1")
//				);
//				PrintWriter escritor = new PrintWriter(ficheroTexto);
				
				PrintStream escritor = new PrintStream(
						new GZIPOutputStream(
							new FileOutputStream("datos.txt.gz")
						),
						false, "UTF-8"
				);
			)
		{
						
			for(int i = 1; i <= 10; i++) {				
				escritor.format("%08d;Nombre %s;Apellidos €ñ %s%n", i, i, i);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		///////////////////////////////////////////////////////////////////////
		
		try
		(
//				BufferedReader lector = new BufferedReader(
//					new FileReader("datos.csv", Charset.forName("UTF-8"))
//				);
				
				Scanner lector = new Scanner(
					new GZIPInputStream(
						new FileInputStream("datos.txt.gz")
					),
					"UTF-8"
				);
		)
		{			
			String linea;
			
// 			while((linea = lector.readLine()) != null) {
			
			while(lector.hasNextLine()) {
				
				linea = lector.nextLine();
				
				String[] datos = linea.split(";");
				System.out.printf("NIF: %s - Nombre: %s - Apellidos: %s%n", datos[0], datos[1], datos[2]);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void empleoFlujosBinarios() {
		// Hay dos tipos de flujos: binarios, texto
		// A su vez de cada tipo surgen dos variaciones: entrada, salida
		
		// Se accede a la información de manera secuencial
		
		try (
//				FileOutputStream ficheroDeDatos = new FileOutputStream("datos.dat");
//				GZIPOutputStream compresor = new GZIPOutputStream(ficheroDeDatos);
//				ObjectOutputStream escritorDatos = new ObjectOutputStream(compresor);
				
				ObjectOutputStream escritorDatos = new ObjectOutputStream(
					new GZIPOutputStream(
						new FileOutputStream("datos.dat")
					)
				);				
			)
		{
			
			int entero = 10;
			boolean algo = true;
			double precio = 10.239393939;
			Cliente cliente = new Cliente("Alberto", "Fernández");
			
			escritorDatos.writeInt(entero);
			escritorDatos.writeBoolean(algo);
			escritorDatos.writeDouble(precio);
			escritorDatos.writeObject(cliente);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//////////////////////////////////////////////////////////////
		
		try
		(
				FileInputStream ficheroDatos = new FileInputStream("datos.dat");				
				GZIPInputStream descompresor = new GZIPInputStream(ficheroDatos);				
				ObjectInputStream lectorDatos = new ObjectInputStream(descompresor);
		)		
		{
			
			int entero = lectorDatos.readInt();
			boolean booleano = lectorDatos.readBoolean();
			double doble = lectorDatos.readDouble();
			Cliente cliente = (Cliente) lectorDatos.readObject();
			
			System.out.printf("%d - %s - %s - %s%n", entero, booleano, doble, cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
