package tp.CicloDeVidaDeLaReserva;

import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class ItemReserva {

    private final Servicio servicio;
    private final Periodo periodo;
    private boolean disfrutado;

    public ItemReserva(Servicio servicio, Periodo periodo){
        this.servicio = servicio;
        this.periodo = periodo;
    }

    public Servicio getServicio(){
        return servicio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public boolean esDisfrutado() {
        return disfrutado;
    }

    public double subtotal(){
        return servicio.getPrecioFinal();
    }

    public boolean esDe(Servicio otroServicio, Periodo otroPeriodo) {
        return servicio == otroServicio && periodo.esElMismoQue(otroPeriodo);
    }

    public void marcarDisfrutado() {
        disfrutado = true;
    }

    // El ítem sabe pedir su cupo: le pasa al servicio su período.
    public void bloquearCupo() {
        servicio.bloquearCupo(periodo);
    }

    public void liberarCupo() {
        servicio.liberarCupo(periodo);
    }
}
