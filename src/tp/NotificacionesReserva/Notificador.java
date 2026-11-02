package tp.NotificacionesReserva;

public class Notificador extends Subsistema{
    private MailSender mailSender;

    @Override
    public void actualizar() {
        mailSender.enviarMail("direccion","titulo",9); 
    }
}
