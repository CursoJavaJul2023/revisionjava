package cursojava.funcionalidad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ProbarEmpleoJDBC {
	
	public static void main(String[] args) {
		
		
		try (
				Connection laConexion = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/curso",
						"curso",
						"Fedora2023"
					);
		) 
		{
			
			// empleoDeStatement(laConexion);
			
			PreparedStatement sqlParametrizado = laConexion.prepareStatement("");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void empleoDeStatement(Connection laConexion) throws SQLException {
		// Statement sqlDinamico = laConexion.createStatement();
		
		Statement sqlDinamico = laConexion.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
		);
		
//			sqlDinamico.executeUpdate(
//				"INSERT INTO DEMOS.CLIENTES (NIF, NOMBRE, APELLIDOS, EMAIL, USUARIO, CLAVE) " +
//					" VALUES ('10101010A', 'Luis', 'Fernández', 'l.f@yahoo.es', 'USR01', 'CLAVE')"
//			);
		
		ResultSet resultadoConsulta = sqlDinamico.executeQuery(
			"SELECT * FROM DEMOS.CLIENTES"
		);
		
		/*
		-----------------------------
		--> before first
		-----------------------------
		datos
		-----------------------------
		after last
		-----------------------------
		*/
		
		mostrarClientes(resultadoConsulta);
		
		resultadoConsulta.beforeFirst();
		
		mostrarClientes(resultadoConsulta);
	}

	public static void mostrarClientes(ResultSet resultadoConsulta) throws SQLException {
		while(resultadoConsulta.next()) {
			String nif = resultadoConsulta.getString("NIF");
			int numero = resultadoConsulta.getInt("NUMERO");
			String nombre = resultadoConsulta.getString("NOMBRE");
			String apellidos = resultadoConsulta.getString("APELLIDOS");
			Timestamp fechaAlta = resultadoConsulta.getTimestamp("FECHAALTA");
			
			System.out.printf("%d|%s|%s|%s|%s%n", numero, nif, nombre, apellidos, fechaAlta);				
		}
	}

}
