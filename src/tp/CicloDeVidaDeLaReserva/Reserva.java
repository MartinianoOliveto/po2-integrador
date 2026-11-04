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
    private final List<ItemReserva> reservas = new ArrayList<ItemReserva>();
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
        return reservas.stream()
                    .mapToDouble(servicio -> servicio.subtotal())
                    .sum();
    }
    
    public double costoTotal(){
        return this.costoServicios() + this.getTasasAdministrativas();
    }
    
    public void cambiarEstado(EstadoReserva nuevo){
        this.estado = nuevo;
    }

    public boolean estaVacia(){
        return items.isEmpty();
    }
    
    public void agregarItem(Servicio servicio, int cantidad){
        // Si cantidad es 0 o negativa 
        if (cantidad <= 0){
            throw new ReservaException("La cantidad debe ser mayor a cero");
        }
        // Entiendo que seria un while y no un foreach a lo boca pero me salio mas rapido asi
        for (ItemReserva item : reservas){
            if (item.getServicio().equals(servicio)){
                item.sumarCantidad(cantidad);
                return;
            }
        }
        reservas.add(new ItemReserva(servicio, cantidad));
    }
    
    public void quitarItem(Servicio servicio){
        // Si encuentro el item, lo quito completamente y sino error
        for (ItemReserva item : reservas){
            if (item.getServicio().equals(servicio)){
                reservas.remove(item);
                return;
            }
        }
        throw new ReservaException("El servicio " + servicio.getNombre() + "no está en la reserva");
    }

    // No es responsabilidad de reserva hacer seguimientos de cupos de los servicios. Lo delego a cada Servicio que creo que son la fuente de verdad
    // de si tiene cupo o no, ademas es una responsabilidad chica de cada uno
    public void bloquearCupos(){
        List<ItemReserva> bloqueados = new ArrayList<ItemReserva>();
        try { // Aplicando lo que enseño Butti
            for (ItemReserva item : reservas){
                item.getServicio().bloquearCupo(item.getCantidad());
                bloqueados.add(item);
            }
        } catch (RuntimeException e) { // Hago roll-back para dejar el estado consistente a otras reservas (si las hay)
            for (ItemReserva item : bloqueados){
                item.getServicio().liberarCupo(item.getCantidad());
            }
            throw e; // Igual lanzo el error para notificar al cliente y que no pase desapercibido
        }

    }
    
    public void liberarCupos(){
        for (ItemReserva item : reservas){
            item.getServicio().liberarCupo(item.getCantidad());
        }
    }
    
    public void emitirVoucher(double monto, String motivo){
        if (monto > 0){
            vouchers.add(new Voucher(monto, motivo));
        }
    }

}
