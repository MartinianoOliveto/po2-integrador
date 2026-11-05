package tp.NotificacionesReserva;

public class DTFidelizacion extends DependencyTransformer {

    public DTFidelizacion(Subsistema target){
        super(target); 
    }
    @Override 
    public void cancelada(){
        target.actualizar(); 
    }

}
