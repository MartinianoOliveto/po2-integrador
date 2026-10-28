package tp.NotificacionesReserva;

public class Notificador extends Subsistema{
    private mailSender mailSender;

    @Override
    public void actualizar() {
        mailSender.enviarMail("direccion","titulo",9); 
    }
}
