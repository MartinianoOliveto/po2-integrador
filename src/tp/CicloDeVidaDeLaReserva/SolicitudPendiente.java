package tp.CicloDeVidaDeLaReserva;

public class SolicitudPendiente extends EstadoReserva {

    @Override
    public void agregarServicio(Reserva reserva, Servicio servicio, int cantidad){
        reserva.agregarItem(servicio, cantidad);
    }
    
    @Override 
    public void quitarServicio(Reserva reserva, Servicio servicio){
        reserva.quitarItem(servicio);
    }
    
    @Override
    public void confirmar(Reserva reserva){
        if(reserva.estaVacia()){
            throw new ReservaException("No se puede confirmar una reserva sin servicios");
        }
        reserva.bloquearCupos();
        reserva.cambiarEstado(new Confirmada());
    }
    
    @Override
    public void cancelar(Reserva reserva){
        reserva.cambiarEstado(new Cancelada());
    }

}
