package tp.CicloDeVidaDeLaReserva;
import tp.CatalogoDeServiciosYPaquetes.Servicio;

import tp.NotificacionesReserva.DependencyTransformer;

public class EnCurso extends EstadoReserva{
    
    public EnCurso(String nombre) {
        super(nombre);
    }

    @Override 
    public void registrarDisfrutado(Reserva reserva, Servicio servicio, Periodo periodo){
        reserva.marcarDisfrutado(servicio, periodo);
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
    //comportamiento relacionado con el observer 
    @Override 
    public void notificar(DependencyTransformer dt,Reserva r){
        dt.enCurso(r);
    }
}
