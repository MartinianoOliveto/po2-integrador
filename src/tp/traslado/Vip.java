package tp.traslado;

public class Vip implements ICalculable {


    private TrasladoVIP trasladoVip; 

    public Vip(TrasladoVIP trasladoVip) {
     this.trasladoVip = trasladoVip;
    }

    @Override
    public float calcularCosto(float valorReserva, int cantPasajeros, Direccion direccion) {
     return trasladoVip.calcularCosto(valorReserva); 
    }
}

