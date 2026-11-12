package tp.CicloDeVidaDeLaReserva;
import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class EnCurso extends EstadoReserva{
    
    public EnCurso(String nombre) {
        super(nombre);
    }

    @Override 
    public void registrarDisfrutado(Reserva reserva, Servicio servicio){
        reserva.marcarDisfrutado(servicio);
    }
    
    @Override
    public void finalizar(Reserva reserva){
        reserva.cambiarEstado(new Finalizada("Finalizada"));
    }
    
    @Override 
    public void cancelar(Reserva reserva){
        reserva.emitirVoucher(reserva.costoServiciosNoDisfrutados(), "Se cancela reserva en curso: Servicios no disfrutados");
        reserva.cambiarEstado(new Cancelada("Cancelada"));
    }
}
