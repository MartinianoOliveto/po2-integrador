package tp.CicloDeVidaDeLaReserva;
import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class Reserva {
    private EstadoReserva estado;
    private final double tasasAdministrativas;
    private final List<ServicioReserva> reservas = new ArrayList<ServicioReserva>();
    private final List<Voucher> vouchers = new ArrayList<Voucher>();
    

    public Reserva(double tasasAdministrativas) {
        this.tasasAdministrativas = tasasAdministrativas;
        this.estado = new SolicitudPendiente();
    }

    // Pensar que el punto de entrada al contexto es el cliente. Toda
    // operacion de un estado es valido dentro de el, pero no toda operacion desde el contexto
    // es valida. Es por eso que el contexto delega en el estado, y se entiende por que deberian haber validaciones.

    // Operaciones de dominio:
    public void confirmar(){
        estado.confirmar(this);
    }

    public void cancelar(){
        estado.cancelar(this);
    }

    public void checkin(){
        estado.checkin(this);
    }
    
    public void iniciar(){
        estado.iniciar(this);
    }
    
    public void registrarDisfrutado(Servicio servicio){
        estado.registrarDisfrutado(this, servicio);
    }

    public void agregarServicio(Servicio servicio, int cantidad){
        estado.agregarServicio(this, servicio, cantidad);
    }
    
    public void quitarServicio(Servicio servicio){
        estado.quitarServicio(this, servicio);        
    }
    
    // Operaciones del contexto:
    
    public double getTasasAdministrativas(){
        return tasasAdministrativas;
    }
    
    public double costoServicios(){
        return servicios.stream()
                    .mapToDouble(servicio -> servicio.subtotal())
                    .sum();
    }
    
    public double costoTotal(){
        return this.costoServicios() + this.getTasasAdministrativas();
    }
    
    public void cambiarEstado(EstadoReserva nuevo){
        this.estado = nuevo;
    }
    
}
