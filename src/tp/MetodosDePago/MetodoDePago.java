package tp.MetodosDePago;

public abstract class MetodoDePago {

    public final void procesarPago(){
        this.validarDatos();
        this.reservarFondos();
        this.ejecutarTransaccion();
        this.notificarResultado();
    }

    protected abstract void validarDatos();
    protected abstract void reservarFondos();
    protected abstract void ejecutarTransaccion();
    protected abstract void notificarResultado(); 

    

}
