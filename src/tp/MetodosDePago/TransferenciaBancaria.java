package tp.MetodosDePago;

public class TransferenciaBancaria extends MetodoDePago implements TransferenciaBancariaAPI{
    private String cbu; 
    private String alias; 
    private float saldo;
    @Override
    public void validarDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarDatos'");
    }
    @Override
    public void ejecutarTransaccion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ejecutarTransaccion'");
    }
    @Override
    protected void reservarFondos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarFondos'");
    }
    @Override
    protected void notificarResultado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarResultado'");
    } 

    

}
