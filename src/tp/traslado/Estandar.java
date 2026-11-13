package tp.traslado;

public class Estandar implements ICalculable {


	private PlataformaTransporte plataforma;

	public Estandar(PlataformaTransporte plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public float calcularCosto(float valorReserva, int cantPasajeros, Direccion direccion) {
		return plataforma.estimarTraslado(cantPasajeros, direccion);
	}
}
