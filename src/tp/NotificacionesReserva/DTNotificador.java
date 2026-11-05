package tp.NotificacionesReserva;

public class DTNotificador extends DependencyTransformer{
    public DTNotificador(Subsistema target) {
        super(target);
    }
    @Override 
    public void confirmada(){
        target.actualizar();
    }
    @Override 
    public void enCurso(){
        target.actualizar();
    }
    @Override 
    public void finalizada(){
        target.actualizar();
    }
}
