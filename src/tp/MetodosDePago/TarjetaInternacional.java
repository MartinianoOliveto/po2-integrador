package tp.MetodosDePago;

public class TarjetaInternacional extends MetodoDePago implements TarjetaInternacionalAPI{

    private String numeroTarjeta; 
    private int CVV; 
    private String vencimiento; 
    private Banco banco; 

    @Override
    public void notificarResultado() {
        banco.notificar();
    }   

    @Override
    public void validarDatos() {
        banco.validarDatos(this);
    }

    @Override
    public void reservarFondos() {
        banco.preautorizar(); 
    }

    @Override
    public void ejecutarTransaccion() {
        banco.ejecutarTransaccion(); 
    }
    
    public TarjetaInternacional(String numTarjeta, int CVV, String vencimiento, Banco banco){
        this.numeroTarjeta = numTarjeta; 
        this.CVV = CVV; 
        this.vencimiento = vencimiento; 
        this.banco = banco; 
    }
}
