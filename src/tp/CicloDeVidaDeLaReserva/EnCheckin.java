package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.DependencyTransformer;

public class EnCheckin extends EstadoReserva{

    public EnCheckin(String nombre) {
        super(nombre);
    }

    @Override 
    public void iniciar(Reserva reserva){
        reserva.cambiarEstado(new EnCurso("EnCurso"));
    }
    
    @Override
    public void cancelar(Reserva reserva){
        reserva.liberarCupos();
        reserva.emitirVoucher(reserva.costoTotal(), "Se cancela la reserva en checkin: servicios y tasas");
        reserva.cambiarEstado(new Cancelada("Cancelada"));
    }
    //comportamiento relacionado con el observer 
    @Override 
    public void notificar(DependencyTransformer dt, Reserva r){
        dt.enCheckin(r);
    }
}
