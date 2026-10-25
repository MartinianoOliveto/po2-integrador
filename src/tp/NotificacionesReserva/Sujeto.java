package tp.NotificacionesReserva;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observador> observadores = new ArrayList<Observador>(); 
    
    public abstract void agregar(Observador o);

    public abstract void remover(Observador o);

    public List<Observador> getObservadores(Observador o){
        return observadores; 
    }
    public abstract void notificar(Sujeto s);


}
