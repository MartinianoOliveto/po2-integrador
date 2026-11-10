package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;
public class Notificador extends Subsistema{
    private MailSender mailSender;

    @Override
    public void actualizar(Reserva r) {
        mailSender.enviarMail("direccion","titulo",9); 
    }
}
