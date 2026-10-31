package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.NotificacionesReserva.DTNotificador;
import tp.NotificacionesReserva.Notificador;
import tp.NotificacionesReserva.Reserva;

public class testDT_Notificador {
    private Reserva r; 
    private Notificador n; 
    private DTNotificador dtn;

    @BeforeEach
    public void setUp(){
        r = mock(Reserva.class); 
        n = mock(Notificador.class);
        dtn = new DTNotificador(n); 
    }

    @Test 
    public void actualizarTest(){
        dtn.actualizar(r); 
        verify(n,times(1)).actualizar(); 
    }
}
