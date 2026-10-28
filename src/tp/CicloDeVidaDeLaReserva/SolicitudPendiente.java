package tp.CicloDeVidaDeLaReserva;

public class SolicitudPendiente extends Estado {
    private Reserva reserva;

    @Override 
    public void procesarContexto(){
        reserva.gestionarServicios();
        this.siguienteContexto();
    }
    public void siguienteContexto(){
        reserva.cambiarEstado(new Confirmada());
    }
    public void cancelarReserva(){
        reserva.cambiarEstado(new Cancelada());
    }
}
