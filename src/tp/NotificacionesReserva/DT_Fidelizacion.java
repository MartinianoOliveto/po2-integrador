package tp.NotificacionesReserva;

public class DT_Fidelizacion extends DependencyTransformer{

    @Override
    public void actualizar(Sujeto s) {
        //aca va la logica de si delega o no
        target.actualizar();
    }

    public DT_Fidelizacion(Subsistema target) {
        super(target);
    }

}
