package tp.testNotificacionesReserva;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.*;
public class testNotificador {
    private Reserva r;
    private Notificador n; 
    private MailSender m;  

    @BeforeEach 
    public void setUp(){
        r=mock(Reserva.class); 
        m=mock(MailSender.class); 
        n=new Notificador(m); 
    }

    @Test
    public void actualizarTest(){
        n.actualizar(r); 
        verify(m,times(1)).enviarMail("direccion","titulo",9); 
    }

}
