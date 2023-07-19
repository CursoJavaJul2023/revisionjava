package cursojava.lenguaje.basico.tipos.clases;

import cursojava.lenguaje.basico.tipos.enumeraciones.Color;

public final class Coche extends Vehiculo {
	
	private final int numeroPuertas;

	public Coche(String marca, String modelo, double potenciaCV, Color color, int numeroPuertas) {
		
		super(marca, modelo, potenciaCV, color);
		this.numeroPuertas = numeroPuertas;		
	}
	
	@Override
	public boolean comprobarEstadoTecnico() {
		
		System.out.println("Comprobando estado en coche ...");
		
		return true;
	}
	
	@Override
	public String[] getPalabrasClave() {
		
		return new String[] { getMarca(), getModelo(), getMatricula(), String.valueOf(numeroPuertas), getColor().toString() };
	}

}
