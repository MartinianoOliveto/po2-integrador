package tp.NotificacionesReserva;

public class Generador_Voucher extends Subsistema{
    private GeneradorVoucher generador; 

    @Override
    public void actualizar() {
        generador.generarVoucher(); 
    }
}
