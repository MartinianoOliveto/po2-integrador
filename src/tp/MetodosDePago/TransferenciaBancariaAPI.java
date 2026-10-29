package tp.MetodosDePago;

public interface TransferenciaBancariaAPI {
    public void validarDatos();
    public void ejecutarTransaccion();
    public void notificarResultado(); 
}
