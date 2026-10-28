package tp.CicloDeVidaDeLaReserva;

public class Confirmada extends Estado {
    private Reserva reserva;

    @Override 
    public void procesarContexto(){

    }
    @Override 
    public void siguienteContexto(){
        
    }
    @Override 
    public void cancelarReserva(){
        reserva.cambiarEstado(new Cancelada(true));
    }

}
