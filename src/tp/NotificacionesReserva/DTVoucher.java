package tp.NotificacionesReserva;

public class DTVoucher extends DependencyTransformer{

    @Override
    public void actualizar(Sujeto s) {
        //Aca va la logica de si delega o no 
        target.actualizar();
    }
    public DTVoucher(Subsistema target){
        super(target); 
    }

}
