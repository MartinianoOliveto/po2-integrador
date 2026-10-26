package tp.NotificacionesReserva;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observador> observadores = new ArrayList<Observador>(); 

    public void agregar(Observador o){
        observadores.add(o);
    }

    public void remover(Observador o){
        observadores.remove(o);
    }

    public List<Observador> getObservadores(Observador o){
        return observadores; 
    }
    public void notificar(Sujeto s){
        observadores.forEach(o->o.actualizar(this));
    }

}
