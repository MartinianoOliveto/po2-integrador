package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.NotificacionesReserva.DTNotificador;
import tp.NotificacionesReserva.Notificador;
import tp.CicloDeVidaDeLaReserva.*;

public class testDTNotificador {
    //private Reserva r; 
    private Notificador n; 
    private DTNotificador dtn;
    private Reserva r;

    @BeforeEach
    public void setUp(){
        //r = mock(Reserva.class); 
        n = mock(Notificador.class);
        dtn = new DTNotificador(n); 
        r=mock(Reserva.class); 
    }

    @Test 
    public void confirmadaActualizaTest(){
        dtn.confirmada(r);
        verify(n,times(1)).actualizar(r); 
    }
    @Test 
    public void enCursoActualizaTest(){
        dtn.enCurso(r);
        verify(n,times(1)).actualizar(r); 
    }
    @Test 
    public void finalizadaActualizaTest(){
        dtn.finalizada(r);
        verify(n,times(1)).actualizar(r); 
    }
    @Test 
    public void canceladaTest(){
        dtn.cancelada(r); 
        verify(n,never()).actualizar(r); 
    }
    @Test 
    public void enCheckinNoHaceNadaTest(){
        dtn.enCheckin(r);
        verify(n,never()).actualizar(r); 
    }
}
