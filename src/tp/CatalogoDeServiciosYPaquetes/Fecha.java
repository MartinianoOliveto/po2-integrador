package tp.CatalogoDeServiciosYPaquetes;

import java.time.LocalDate;

public class Fecha implements ITipoDeValor<LocalDate>{
    @Override
    public void validarTipo(LocalDate valor) {
        if (valor == null) {
            throw new RuntimeException("La fecha no puede ser nula.");
        }
    }
 }