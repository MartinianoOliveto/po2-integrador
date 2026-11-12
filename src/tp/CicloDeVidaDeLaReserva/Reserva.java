package tp.CicloDeVidaDeLaReserva;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;

public class Reserva {
    private EstadoReserva estado;
    private final double tasasAdministrativas;
    private final ServiciosReservados servicios = new ServiciosReservados();
    private final List<Voucher> vouchers = new ArrayList<Voucher>();
    

    public Reserva(double tasasAdministrativas) {
        this.tasasAdministrativas = tasasAdministrativas;
        this.estado = new SolicitudPendiente("SolicitudPendiente");
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
    
    // Modelo colaboradores como sugirio el profe para el tema de fechas y cupos
    public void registrarDisfrutado(Servicio servicio, Periodo periodo){
        estado.registrarDisfrutado(this, servicio, periodo);
    }

    public void agregarServicio(Servicio servicio, Periodo periodo){
        estado.agregarServicio(this, servicio, periodo);
    }
    
    public void quitarServicio(Servicio servicio, Periodo periodo){
        estado.quitarServicio(this, servicio, periodo);        
    }
    
    // Operaciones del contexto:
    public double getTasasAdministrativas(){
        return tasasAdministrativas;
    }
    
    public double costoServicios(){
        return servicios.costoTotal();
    }
    
    public double costoTotal(){
        return this.costoServicios() + this.getTasasAdministrativas();
    }
    
    public void cambiarEstado(EstadoReserva nuevo){
        this.estado = nuevo;
    }

    public void emitirVoucher(double monto, String motivo){
        if (monto > 0){
            vouchers.add(new Voucher(monto, motivo));
        }
    }
    
}
