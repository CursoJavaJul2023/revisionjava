package cursojava.lenguaje.basico.tipos.enumeraciones;

public enum TipoDeCliente {
	
	NORMAL(100, 0.0, false),
	PREMIUM(200, 5.0, true),
	VIP(300, 10.0, true);
	
	private int codigo;
	private double descuento;
	private boolean recibirAlertas;	
	
	private TipoDeCliente(int codigo, double descuento, boolean recibirAlertas) {
		this.codigo = codigo;
		this.descuento = descuento;
		this.recibirAlertas = recibirAlertas;
	}

	public int codigo() {
		return codigo;
	}

	public double descuento() {
		return descuento;
	}

	public boolean recibirAlertas() {
		return recibirAlertas;
	}

}
