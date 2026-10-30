package tp.traslado;

public class Vip implements ICalculable {

    private float valorReserva;
    private TrasladoVIP trasladoVip; 

    public Vip(float valorReserva, TrasladoVIP trasladoVip) {
     this.valorReserva = valorReserva;
     this.trasladoVip = trasladoVip;
    }

    @Override
    public float calcularCosto() {
     return trasladoVip.calcularCosto(valorReserva); 
    }
}

