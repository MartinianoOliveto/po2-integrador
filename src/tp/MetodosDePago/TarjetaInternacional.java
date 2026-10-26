package tp.MetodosDePago;

import java.time.LocalDate;

public class TarjetaInternacional extends MetodoDePago implements TarjetaInternacionalAPI{

    private String numeroTarjeta; 
    private int CVV; 
    private LocalDate vencimiento; 
    //private Banco banco; ????

    @Override
    protected void notificarResultado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarResultado'");
    }

    @Override
    public void validarDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarDatos'");
    }

    @Override
    public void reservarFondos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarFondos'");
    }

    @Override
    public void ejecutarTransaccion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ejecutarTransaccion'");
    }
    
}
