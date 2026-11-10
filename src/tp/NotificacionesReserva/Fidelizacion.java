package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;
public class Fidelizacion extends Subsistema{
    private GeneradorCuponAPI generadorCupon; 

    @Override
    public void actualizar(Reserva r) {
        generadorCupon.generarCupon(r); 
    }

}
