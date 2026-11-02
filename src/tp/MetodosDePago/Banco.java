package tp.MetodosDePago;

public interface Banco {
    public void preautorizar(); 
    public void validarDatos(TarjetaInternacional t); 
    public void ejecutarTransaccion(); 
    public void notificar(); 
}
