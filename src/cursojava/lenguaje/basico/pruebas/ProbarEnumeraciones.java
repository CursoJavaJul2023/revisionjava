package cursojava.lenguaje.basico.pruebas;

import cursojava.lenguaje.basico.tipos.enumeraciones.Color;
import cursojava.lenguaje.basico.tipos.enumeraciones.TipoDeCliente;

public class ProbarEnumeraciones {
	
	public static void main(String[] args) {
		
		Color unColor = Color.VERDE;
		
		// Se pueden emplear en switch
		
		switch (unColor) {
		case AZUL:
			
			break;
		case ROJO:
		case BLANCO:
			
			break;

		default:
			break;
		}
		
		for (Color color : Color.values()) {
			System.out.printf("Valor: %s - Pos: %d%n", color.toString(), color.ordinal());
		}
		
		Color azul = Color.valueOf("AZUL");
		
		if(azul == Color.AZUL) {
			System.out.println("El color es azul");
		}
		
		////////////////////////////////////////////////////////////////////////////
		
		TipoDeCliente tipo = TipoDeCliente.PREMIUM;
		
		System.out.println(tipo);
		
		for (TipoDeCliente t : TipoDeCliente.values()) {
			System.out.printf("Código: %d - Descuento: %f - Alertas: %s%n", t.codigo(), t.descuento(), t.recibirAlertas());
		}
		
	}

}






