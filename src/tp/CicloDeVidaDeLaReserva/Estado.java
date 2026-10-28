package tp.CicloDeVidaDeLaReserva;

/**
 * Modelo el Estado de la Reserva. Cada estado que la implemente
 * conceptualiza una Linked List: Cada uno pasa a su siguiente en el proceso (no tiene anterior) o puede ser cancelado en cualquier momento
 */
public abstract class Estado {
    public abstract void procesarContexto();
    public abstract void cancelarReserva();
    public abstract void siguienteContexto();
}
