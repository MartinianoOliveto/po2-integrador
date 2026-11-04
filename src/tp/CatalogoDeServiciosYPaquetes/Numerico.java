package tp.CatalogoDeServiciosYPaquetes;

public class Numerico implements ITipoDeValor<Double> {

@Override
    public void validarTipo(Double valor) {
        if (valor == null) {
            throw new RuntimeException("El valor numérico no puede ser nulo.");
        }
    }
}
