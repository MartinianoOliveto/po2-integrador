package tp.MetodosDePago;

public class TarjetaInternacional extends MetodoDePago{

    private String numeroTarjeta; 
    private int CVV; 
    private String vencimiento; 
    private TarjetaInternacionalAPI api;  

    @Override
    protected void notificarResultado() {
        api.notificarResultado();
    }   
    @Override
    protected void validarDatos() {
        api.validarDatos(this);
    }
    @Override
    protected void reservarFondos() {
        api.reservarFondos(); 
    }
    @Override
    protected void ejecutarTransaccion() {
        api.ejecutarTransaccion(); 
    }
    public TarjetaInternacional(String numTarjeta, int CVV, String vencimiento, TarjetaInternacionalAPI api){
        this.numeroTarjeta = numTarjeta; 
        this.CVV = CVV; 
        this.vencimiento = vencimiento; 
        this.api = api; 
    }
}
