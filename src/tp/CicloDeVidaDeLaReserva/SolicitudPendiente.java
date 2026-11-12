package tp.CicloDeVidaDeLaReserva;

import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class SolicitudPendiente extends EstadoReserva {

    public SolicitudPendiente(String nombre) {
        super(nombre);
    }

    @Override
    public void agregarServicio(Reserva reserva, Servicio servicio, Periodo periodo){
        reserva.agregarItem(servicio, periodo);
    }
    
    @Override 
    public void quitarServicio(Reserva reserva, Servicio servicio, Periodo periodo){
        reserva.quitarItem(servicio, periodo);
    }
    
    @Override
    public void confirmar(Reserva reserva){
        if(reserva.estaVacia()){
            throw new ReservaException("No se puede confirmar una reserva sin servicios");
        }
        reserva.bloquearCupos();
        reserva.cambiarEstado(new Confirmada("Confirmada"));
    }
    
    @Override
    public void cancelar(Reserva reserva){
        reserva.cambiarEstado(new Cancelada("Cancelada"));
    }

}
