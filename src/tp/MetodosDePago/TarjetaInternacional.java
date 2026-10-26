package tp.MetodosDePago;

public class TarjetaInternacional extends MetodoDePago{

    private String numeroTarjeta; 
    private int CVV; 
    private String vencimiento; 
    private TarjetaInternacionalAPI api;  
    //herencia de interfaces??

    @Override
    public void notificarResultado() {
        api.notificarResultado();
    }   

    @Override
    public void validarDatos() {
        api.validarDatos(this);
    }

    @Override
    public void reservarFondos() {
        api.reservarFondos(); 
    }

    @Override
    public void ejecutarTransaccion() {
        api.ejecutarTransaccion(); 
    }
    
    public TarjetaInternacional(String numTarjeta, int CVV, String vencimiento, TarjetaInternacionalAPI api){
        this.numeroTarjeta = numTarjeta; 
        this.CVV = CVV; 
        this.vencimiento = vencimiento; 
        this.api = api; 
    }
}
