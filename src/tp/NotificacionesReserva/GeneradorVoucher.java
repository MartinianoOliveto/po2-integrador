package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public class GeneradorVoucher extends Subsistema{ 
    private GeneradorVoucherAPI generadorVoucher; 
    @Override
    public void actualizar(Reserva r) {
        generadorVoucher.generarVoucher(r); 
    }
}
