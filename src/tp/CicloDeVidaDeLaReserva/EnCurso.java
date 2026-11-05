package tp.CicloDeVidaDeLaReserva;

public class EnCurso extends EstadoReserva{
    
    @Override 
    public void registrarDisfrutado(Reserva reserva, Servicio servicio){
        reserva.marcarDisfrutado(servicio);
    }
    
    @Override
    public void finalizar(Reserva reserva){
        reserva.cambiarEstado(new Finalizada());
    }
    
    @Override 
    public void cancelar(Reserva reserva){
        reserva.emitirVoucher(reserva.costoServiciosNoDisfrutados(), "Se cancela reserva en curso: Servicios no disfrutados");
        reserva.cambiarEstado(new Cancelada());
    }
}
