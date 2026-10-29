package tp.NotificacionesReserva;

public class DT_Generador_Voucher extends DependencyTransformer{

    @Override
    public void actualizar(Sujeto s) {
        //Aca va la logica de si delega o no 
        target.actualizar();
    }
    public DT_Generador_Voucher(Subsistema target){
        super(target); 
    }

}
