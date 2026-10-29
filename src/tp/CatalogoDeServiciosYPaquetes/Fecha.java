package tp.CatalogoDeServiciosYPaquetes;

import java.time.LocalDate;

public class Fecha implements ITipoDeValor<Boolean>{
    @Override
    public void validarTipo(Boolean valor) {
        if (valor == null) {
            throw new RuntimeException("El valor no puede ser nulo.");
        }
    }

    public void validar(LocalDate valor) {
        if (valor == null) {
            throw new RuntimeException("La fecha no puede ser nula.");
        }
    }
}