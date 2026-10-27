package tp.MetodosDePago;

public class TransferenciaBancaria extends MetodoDePago{
    private String cbu; 
    private String alias; 
    private float saldo;
    private TransferenciaBancariaAPI api;
    @Override
    protected void validarDatos() {
        api.validarDatos();
    }
    @Override
    protected void reservarFondos() {
        
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
