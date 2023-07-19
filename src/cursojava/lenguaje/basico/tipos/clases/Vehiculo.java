package cursojava.lenguaje.basico.tipos.clases;

import java.util.Objects;

import cursojava.lenguaje.basico.tipos.enumeraciones.Color;
import cursojava.lenguaje.basico.tipos.interfaces.Catalogable;
import cursojava.lenguaje.basico.tipos.interfaces.CatalogoYPosicion;

public abstract class Vehiculo implements CatalogoYPosicion {
	
	private String marca;
	private String modelo;
	private String matricula;
	private double potenciaCV;
	private Color color;
	
	public static String plantillaVehiculo = "Vehiculo [marca=%s, modelo=%s, matricula=%s, potenciaCV=%s, color=%s]";	
	
	public Vehiculo(String marca, String modelo, double potenciaCV, Color color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.potenciaCV = potenciaCV;
		this.color = color;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMatricula() {
		return matricula;
	}

	public double getPotenciaCV() {
		return potenciaCV;
	}


	public void setPotenciaCV(double potenciaCV) {
		this.potenciaCV = potenciaCV;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	public final void matricular(String matricula) {
		
		this.matricula = matricula;
		
		System.out.println("Matriculando vehículo ...");
	}
	
	public abstract boolean comprobarEstadoTecnico();
	
//	public boolean comprobarEstadoTecnico() {
//		
//		System.out.println("Comprobando estado vehículo ...");
//		
//		return true;
//	}
	
	@Override
	public String getIdUnico() {
		
		return matricula;
	}
	
	@Override
	public double getLat() {
		return 0;
	}
	
	@Override
	public double getLon() {
		return 0;
	}


	@Override
	public String toString() {
		return String.format(plantillaVehiculo, marca, modelo,
				matricula, potenciaCV, color);
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	
	

}
