package tp.CicloDeVidaDeLaReserva;

public class Voucher {
    private final double monto;
    private final String motivo;
    
    public Voucher(double monto, String motivo){
        this.monto = monto;
        this.motivo = motivo;
    }

    public double getMonto(){
        return monto;
    }
}
