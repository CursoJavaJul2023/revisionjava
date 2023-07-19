package cursojava.lenguaje.basico.excepciones;

import java.sql.SQLException;

import cursojava.lenguaje.basico.tipos.clases.Cliente;
import cursojava.lenguaje.basico.tipos.enumeraciones.TipoError;

public class ServicioGestionClientes {
	
	
	public void alta(Cliente cte) throws ServicioGestionClientesException {
		
		
		if(!cte.getNombre().matches("^[a-zA-Z]{3,20}$")) {			
			throw new ServicioGestionClientesException(
					TipoError.GESTION_CLIENTES_NOMBRE_INCORRECTO, 
					"Nombre incorrecto " + cte.getNombre(), cte.getNombre());
		}
		
		// Simulamos error en la base de datos
		
		try {
			
			if(cte.getApellidos().length() >= 20) {
				throw new SQLException("Longitud en columna APELLIDOS superada", "ERR1000", 1000);
			}
			
		} catch (SQLException e) {
			
			throw new ServicioGestionClientesException(
					TipoError.GESTION_CLIENTES_ERROR_BASE_DE_DATOS, 
					"Problema en base de datos", e, null);
		}
		
		
	}

}
