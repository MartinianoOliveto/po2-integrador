package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.*;

public class Confirmada extends EstadoReserva {

    @Override
    public void checkin(Reserva reserva){
        reserva.cambiarEstado(new EnCheckin());
    }
    
    // Cancelar desde confirmada deberia reembolsar como EnCheckin por que en ambos casos ya se pago por los servicios
    @Override 
    public void cancelar(Reserva reserva){
        reserva.liberarCupos();
        reserva.emitirVoucher(reserva.costoTotal(), "Se cancela la reserva confirmada");
        reserva.cambiarEstado(new Cancelada());
    }
    //comportamiento relacionado con el observer 
    public void notificar(DependencyTransformer dt){
        dt.confirmada();
    }
}
