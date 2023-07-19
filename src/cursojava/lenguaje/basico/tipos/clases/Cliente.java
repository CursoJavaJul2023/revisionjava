package cursojava.lenguaje.basico.tipos.clases;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import cursojava.lenguaje.basico.tipos.anotaciones.ControlCalidad;
import cursojava.lenguaje.basico.tipos.interfaces.Catalogable;

@ControlCalidad
public class Cliente extends Object implements Catalogable, Cloneable, Comparable<Cliente>, Serializable {	
	
	/*
	 Visibilidad
	 
	 public -> público // acceso libre desde cualquier bloque
	 private -> privado // sólo desde dentro del tipo
	 protected -> protegido // desde subtipos 
	 							y desde tipos definidos 
	 							en el mismo paquete
	 default -> paquete // desde tipos definidos en el mismo
	                        paquete	 
	 */
	
	// Campos/propiedades
	private String nombre;
	private String apellidos;
	private String uuid;
	
//	private String algo = generarIdUnico();
//	
//	@Override
//	public String generarIdUnico() {
//		// TODO Auto-generated method stub
//		return Catalogable.super.generarIdUnico();
//	}
	
	public Cliente() {
		this.uuid = UUID.randomUUID().toString();
	}
		
	public Cliente(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.uuid = UUID.randomUUID().toString();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return String.format("Cliente [nombre=%s, apellidos=%s, uuid=%s]", nombre, apellidos, uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String[] getPalabrasClave() {
		
		return new String[] { nombre, apellidos };
	}

	@Override
	public String getIdUnico() {
		
		return uuid;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return new Cliente(nombre, apellidos);
	}

	@Override
	public int compareTo(Cliente o) {
		
		String actual = String.format("%s%s", nombre, apellidos);
		String otro = String.format("%s%s", o.nombre, o.apellidos);
		
		return actual.compareTo(otro);
	}

}
