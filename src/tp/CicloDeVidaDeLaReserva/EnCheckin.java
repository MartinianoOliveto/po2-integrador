package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.DependencyTransformer;

public class EnCheckin extends EstadoReserva{

    @Override 
    public void iniciar(Reserva reserva){
        reserva.cambiarEstado(new EnCurso());
    }
    
    @Override
    public void cancelar(Reserva reserva){
        reserva.liberarCupos();
        reserva.emitirVoucher(reserva.costoTotal(), "Se cancela la reserva en checkin: servicios y tasas");
        reserva.cambiarEstado(new Cancelada());
    }
    //comportamiento relacionado con el observer 
    public void notificar(DependencyTransformer dt){
        dt.enCheckin();
    }
}
