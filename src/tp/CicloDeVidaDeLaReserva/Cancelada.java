package tp.CicloDeVidaDeLaReserva;

public class Cancelada extends Estado{
    private Reserva reserva;
    private boolean hayQueLiberar = false;
    
    public Cancelada(){}
    public Cancelada(boolean hayQueLiberar){
        this.hayQueLiberar = hayQueLiberar;
    }
    
    @Override
    public void procesarContexto(){
        if (hayQueLiberar){
            reserva.liberarCupo();
        }
    }
    @Override
    public void cancelarReserva(){
        
    }
    @Override
    public void siguienteContexto(){

    }
}
