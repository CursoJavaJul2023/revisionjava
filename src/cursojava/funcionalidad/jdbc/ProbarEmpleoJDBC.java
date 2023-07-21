package cursojava.funcionalidad.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

public class ProbarEmpleoJDBC {
	
	public static void main(String[] args) {
		
		
		try (
				Connection laConexion = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/curso?escapeSyntaxCallMode=callIfNoReturn",
						"curso",
						"Fedora2023"
					);
		) 
		{
			
			// empleoDeStatement(laConexion);
			
			// empleoDePrepareStatement(laConexion);
			
			// empleoDeCallableStatement(laConexion);
			
			// empleoTransacciones(laConexion);
			
			// consultarMetadatos(laConexion);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void consultarMetadatos(Connection laConexion) throws SQLException {
		DatabaseMetaData dbInfo = laConexion.getMetaData();
		
		System.out.printf(
			"Producto: %s - Versión: %s%nDriver: %s - Versión: %s%n",
			dbInfo.getDatabaseProductName(),
			dbInfo.getDatabaseProductVersion(),
			dbInfo.getDriverName(),
			dbInfo.getDriverVersion()
		);
		
		ResultSet tablas = dbInfo.getTables("%", "%", "%", new String[] { "TABLE" });
		while(tablas.next()) {
			System.out.printf(
				"%20s|%20s%n",
				tablas.getString("TABLE_SCHEM"),
				tablas.getString("TABLE_NAME")
			);
		}
	}

	public static void empleoTransacciones(Connection laConexion) throws SQLException {
		try {
			laConexion.setAutoCommit(false);
			
			Statement sql = laConexion.createStatement();
			
			sql.executeUpdate("DELETE FROM DEMOS.ARTICULOS");
			
			sql.executeUpdate(
				"INSERT INTO DEMOS.ARTICULOS (CODIGO, NOMBRE, PRECIOUNIDAD) VALUES ('COD100', 'Artículo 1', 100.0)"
			);
			
			sql.executeUpdate(
				"INSERT INTO DEMOS.ARTICULOS (CODIGO, NOMBRE, PRECIOUNIDAD) VALUES ('COD200', 'Artículo 2', 100.0)"
			);
			
			sql.executeUpdate(
				"INSERT INTO DEMOS.ARTICULOS (CODIGO, NOMBRE, PRECIOUNIDAD) VALUES ('COD100', 'Artículo 3', 100.0)"
			);
			
			laConexion.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();

			laConexion.rollback();
		}
	}

	public static void empleoDeCallableStatement(Connection laConexion) throws SQLException {
		CallableStatement invocarProcedimiento = laConexion.prepareCall(
			"{ CALL probar_desde_java( ?, ?, ?, ?, ?, ? ) }"
		);
		
		// Para parámetros IN | INOUT
		
		invocarProcedimiento.setInt(1, 10);
		invocarProcedimiento.setInt(2, 20);
		invocarProcedimiento.setInt(3, 30);
		invocarProcedimiento.setInt(4, 10);
		invocarProcedimiento.setInt(5, 10);
		invocarProcedimiento.setInt(6, 10);
		
		// Para parámetros OUT | INOUT
		
		invocarProcedimiento.registerOutParameter(4, Types.NUMERIC);
		invocarProcedimiento.registerOutParameter(5, Types.NUMERIC);
		invocarProcedimiento.registerOutParameter(6, Types.NUMERIC);
		
		invocarProcedimiento.executeUpdate();
		
		// Para leer los valores que se devuelven en parámetros OUT | INOUT
					
		BigDecimal mayor = invocarProcedimiento.getBigDecimal(4);
		BigDecimal menor = invocarProcedimiento.getBigDecimal(5);
		BigDecimal producto = invocarProcedimiento.getBigDecimal(6);
		
		System.out.printf("Mayor: %s - Menor: %s - Producto: %s%n", mayor, menor, producto);
	}

	public static void empleoDePrepareStatement(Connection laConexion) throws SQLException {
		PreparedStatement sqlParametrizado = laConexion.prepareStatement(
				"INSERT INTO DEMOS.CLIENTES (NIF, NOMBRE, APELLIDOS, EMAIL, USUARIO, CLAVE) " +
				" VALUES (?, ?, ?, ?, ?, ?)"
		);
		
		sqlParametrizado.setString(3, "Apellidos");
		sqlParametrizado.setString(4, "usuario@yahoo.es");
		sqlParametrizado.setString(6, "clave");
		
		for(int i = 1; i <= 10; i++) {
			sqlParametrizado.setString(1, String.format("%08dA",i));
			sqlParametrizado.setString(2, "Nombre " + i);
			sqlParametrizado.setString(5, "Usuario " + i);
			
			sqlParametrizado.executeUpdate();
		}
		
		PreparedStatement consulta = laConexion.prepareStatement(
			"SELECT * FROM DEMOS.CLIENTES WHERE NOMBRE LIKE ? OR USUARIO LIKE ?"
		);
		
		consulta.setString(1, "%2");
		consulta.setString(2, "%1");
		
		ResultSet resultado = consulta.executeQuery();
		
		mostrarClientes(resultado);
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
