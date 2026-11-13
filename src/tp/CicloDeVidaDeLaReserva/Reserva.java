package tp.CicloDeVidaDeLaReserva;
import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;
import tp.NotificacionesReserva.*;
import java.util.Collections;

public class Reserva extends Sujeto{
    private EstadoReserva estado;
    private final double tasasAdministrativas;
    private final ServiciosReservados servicios = new ServiciosReservados();
    private final List<Voucher> vouchers = new ArrayList<Voucher>();
    

    public Reserva(double tasasAdministrativas) {
        this.tasasAdministrativas = tasasAdministrativas;
        this.estado = new SolicitudPendiente("Solicitud Pendiente");
    }

    // Pensar que el punto de entrada al contexto es el cliente. Toda
    // operacion de un estado es valido dentro de el, pero no toda operacion desde el contexto
    // es valida. Es por eso que el contexto delega en el estado, y se entiende por que deberian haber validaciones.

    // Operaciones de dominio:
    public void confirmar(){
        estado.confirmar(this);
        this.notificar(this);
        
    }

    public void cancelar(){
        estado.cancelar(this);
        this.notificar(this);
        
    }

    public void checkin(){
        estado.checkin(this);
        this.notificar(this);
        
    }
    
    public void iniciar(){
        estado.iniciar(this);
        this.notificar(this);
    }
    @Override 
    public void delegarNotificacion(DependencyTransformer dt){
        estado.notificar(dt,this); 
    }

    public void finalizar(){
        estado.finalizar(this);
        this.notificar(this);
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

    public List<Voucher> getVouchers(){
        return Collections.unmodifiableList(vouchers);
    }

    public EstadoReserva getEstado(){
        return estado;
    }

    public void agregarItem(Servicio servicio, Periodo periodo){
        servicios.agregar(servicio, periodo);
    }

    public void quitarItem(Servicio servicio, Periodo periodo){
        servicios.quitar(servicio, periodo);
    }

    public void marcarDisfrutado(Servicio servicio, Periodo periodo){
        servicios.marcarDisfrutado(servicio, periodo);
    }

    public boolean estaVacia(){
        return servicios.estaVacio();
    }

    public void bloquearCupos(){
        servicios.bloquearCupos();
    }

    public void liberarCupos(){
        servicios.liberarCupos();
    }

    public double costoServiciosNoDisfrutados(){
        return servicios.costoNoDisfrutados();
    }
    
}
