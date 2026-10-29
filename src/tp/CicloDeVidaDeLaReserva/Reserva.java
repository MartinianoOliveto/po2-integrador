package tp.CicloDeVidaDeLaReserva;
import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;

public class Reserva {
    private EstadoReserva estado;
    private List<CupoReserva> cupos = new ArrayList<CupoReserva>();
    private List<Voucher> vouchers = new ArrayList<Voucher>();
    private double tasasAdministrativas;
    
    public Reserva(double tasasAdministrativas){
        this.tasasAdministrativas = tasasAdministrativas;
        estado = new SolicitudPendiente();
    }
    
    // Operaciones de dominio: pensar que el punto de entrada es el cliente con el contexto. Debe haber una delegacion !!
    public void agregarServicio(Servicio servicio, int cantidad){
        estado.agregarServicio(this, servicio, cantidad);
    }

    public void quitarServicio(Servicio servicio){
        estado.quitarServicio(this, servicio);
    }

    public void confirmar() {
        estado.confirmar(this);
    }

    public void hacerCheckin() {
        estado.hacerCheckin(this);
    }

    public void iniciar() {
        estado.iniciar(this);
    }

    // Marca un servicio como ya disfrutado durante el viaje
    public void registrarConsumo(Servicio servicio) {
        estado.registrarConsumo(this, servicio);
    }

    public void finalizar() {
        estado.finalizar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    // Operaciones de la reserva en si (no dependen del estado)
    public void cambiarEstado(EstadoReserva estado){
        this.estado = estado;
    }
    
}
