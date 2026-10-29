package tp.NotificacionesReserva;

public class DTFidelizacion extends DependencyTransformer {

    @Override
    public void actualizar(Sujeto s) {
        //Aca va la logica de si delega o no 
        target.actualizar(); 
    }
    public DTFidelizacion(Subsistema target){
        super(target); 
    }

}
