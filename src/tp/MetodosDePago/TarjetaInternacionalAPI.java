package tp.MetodosDePago;

public interface TarjetaInternacionalAPI {
    public void validarDatos(TarjetaInternacional t);
    public void reservarFondos();
    public void ejecutarTransaccion();
    public void notificarResultado();
}
