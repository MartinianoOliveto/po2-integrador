package tp.MetodosDePago;

public class BilleteraVirtual extends MetodoDePago{
    private float saldo;
    private BilleteraVirtualAPI api;
    @Override
    protected void validarDatos() {
        api.validarDatos();
    }
    @Override
    protected void reservarFondos() {
        api.reservarFondos();
    }
    @Override
    protected void ejecutarTransaccion() {
        api.ejecutarTransaccion();
    }
    @Override
    protected void notificarResultado() {
        api.notificarResultado();
    } 



 
    

}
