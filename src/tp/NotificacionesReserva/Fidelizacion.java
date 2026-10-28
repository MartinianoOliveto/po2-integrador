package tp.NotificacionesReserva;

public class Fidelizacion extends Subsistema{
    private GeneradorCupon generador;

    @Override
    public void actualizar() {
        generador.generarCupon(); 
    } 

}
