package tp.CatalogoDeServiciosYPaquetes;

public class Booleano implements ITipoDeValor<Boolean> {

    @Override
    public void validarTipo(Boolean valor) {
        if (valor == null) {
            throw new RuntimeException("El valor booleano no puede ser nulo.");
        }
    }
}