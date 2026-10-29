package tp.NotificacionesReserva;

public abstract class DependencyTransformer implements Observador{
    protected Subsistema target;
    public DependencyTransformer(Subsistema target){
        this.target = target; 
    }
}
