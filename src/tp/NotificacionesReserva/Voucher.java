package tp.NotificacionesReserva;

public class Voucher extends Subsistema{
    private GeneradorVoucher generador; 

    @Override
    public void actualizar() {
        generador.generarVoucher(); 
    }
}
