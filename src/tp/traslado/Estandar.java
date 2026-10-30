package tp.traslado;

public class Estandar implements ICalculable {

	private int cantPasajeros;
	private Direccion direccion;
	private PlataformaTransporte plataforma;

	public Estandar(int cantPasajeros, Direccion direccion, PlataformaTransporte plataforma) {
		this.cantPasajeros = cantPasajeros;
		this.direccion = direccion;
		this.plataforma = plataforma;
	}

	@Override
	public float calcularCosto() {
		return plataforma.estimarTraslado(cantPasajeros, direccion);
	}
}
