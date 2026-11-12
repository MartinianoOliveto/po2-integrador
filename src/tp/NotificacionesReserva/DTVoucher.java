package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public class DTVoucher extends DependencyTransformer{

    @Override 
    public void finalizada(Reserva r){
        target.actualizar(r); 
    }
    public DTVoucher(Subsistema target){
        super(target); 
    }

}
