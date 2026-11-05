package tp.NotificacionesReserva;

public class DTVoucher extends DependencyTransformer{

    @Override 
    public void finalizada(){
        target.actualizar(); 
    }
    public DTVoucher(Subsistema target){
        super(target); 
    }

}
