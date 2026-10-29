package tp.CatalogoDeServiciosYPaquetes;

public class Texto implements ITipoDeValor<String> {

    @Override
    public void validarTipo(String valor) {
        if (valor == null) {
         throw new RuntimeException("El texto no puede estar vacío.");
        }
    }
}