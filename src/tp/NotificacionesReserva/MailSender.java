package tp.NotificacionesReserva;

public interface MailSender {
    public void enviarMail(String direccion, String titulo,Object adjunto);
}
