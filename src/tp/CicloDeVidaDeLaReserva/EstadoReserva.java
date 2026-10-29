package tp.CicloDeVidaDeLaReserva;

public abstract class EstadoReserva{

    public void agregarServicio(Reserva reserva, Servicio servicio){
        throw invalida("agregar un servicio");
    }
    
    public void quitarServicio(Reserva reserva, Servicio servicio){
        throw invalida("quitar un servicio");
    }
    
    public void confirmar(Reserva reserva){
        throw invalida("confirmar");
    }
    
    public void hacerCheckin(Reserva reserva){
        throw invalida("hacer el checkin");
    }
    
    public void iniciar(Reserva reserva){
        throw invalida("iniciar el viaje");
    }
    
    public void finalizar (Reserva reserva){
        throw invalida("finalizar");
    }
    
    public void cancelar(Reserva reserva){
        throw invalida("cancelar");
    }
    
    private OperacionInvalidaException invalida(String operacion){
        return new OperacionInvalidaException(tipo(), operacion);
    }
}
