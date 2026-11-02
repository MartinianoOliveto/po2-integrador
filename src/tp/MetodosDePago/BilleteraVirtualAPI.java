package tp.MetodosDePago;

public interface BilleteraVirtualAPI {
    public void validarDatos();
    public void reservarFondos();
    public void ejecutarTransaccion();
    public void notificarResultado(); 
}
