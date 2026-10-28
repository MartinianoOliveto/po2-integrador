package tp.CicloDeVidaDeLaReserva;

/**
 * Modelo el Estado de la Reserva. Cada estado que la implemente
 * conceptualiza una Linked List: Cada uno pasa a su siguiente en el proceso (no tiene anterior) o puede ser cancelado en cualquier momento
 */
public abstract class Estado {
    public void procesar(Reserva reserva){throw invalida("procesar");}
    public void cancelar(Reserva reserva){throw invalida("cancelar");}
    public void cambiar(Reserva reserva){throw invalida("cambiar");}
    
    protected abstract String nombre();
    
    private OperacionInvalidaException invalida(String operacion){
        return new OperacionInvalidaException(
            "No se puede " + operacion + " una reserva " + nombre());
        
    }
}
