package tp.NotificacionesReserva;

public class DTNotificador extends DependencyTransformer{

    @Override
    public void actualizar(Sujeto s) {
        //aca va la logica de si delega o no
        target.actualizar();
    }

    public DTNotificador(Subsistema target) {
        super(target);
    }

}
