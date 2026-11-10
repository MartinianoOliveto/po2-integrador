package tp.NotificacionesReserva;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    protected List<Observador> observadores = new ArrayList<Observador>(); 
    //Aca considero que es correcto validar y romper si se quiere agregar 
    //un observador repetido, hacerlo puede hacer que se genere un bug en el
    //sistema, el observador se notificaria 2 veces (o incluso mas )
    public void agregar(Observador o){
        this.validarExistencia(o); 
        observadores.add(o);
    }
    //Considero que no es necesario tirar error, ya que sacar algo que no existe 
    //en el sistema, no pasa nada 
    public void remover(Observador o){
        if(observadores.contains(o)){
            observadores.remove(o);
        }
    }

    public List<Observador> getObservadores(){
        return observadores; 
    }
    public void notificar(Sujeto s){
        observadores.forEach(o->o.actualizar(this));
    }
    public abstract void delegarNotificacion(DependencyTransformer dt);

    private void validarExistencia(Observador o){
        if(observadores.contains(o)){
            throw new SujetoException("El observador ya está registrado");
        }
    }
}
