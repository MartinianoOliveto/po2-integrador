package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.DTNotificador;

public class testEstados {
    private Cancelada cancelada; 
    private Confirmada confirmada; 
    private EnCurso enCurso; 
    private Finalizada finalizada;
    private EnCheckin enCheckin; 
    private Reserva reserva; 
    private DTNotificador notificador; 

    @BeforeEach 
    public void setUp(){
        reserva =mock(Reserva.class); 
        notificador=mock(DTNotificador.class); 
        cancelada = new Cancelada("Cancelada"); 
        confirmada = new Confirmada("Confirmada");
        enCurso = new EnCurso("En Curso");
        finalizada = new Finalizada("Finalizada");
        enCheckin = new EnCheckin("En Checkin"); 
    }
    @Test
    public void notificarTest(){
        cancelada.notificar(notificador, reserva); 
        confirmada.notificar(notificador, reserva); 
        enCurso.notificar(notificador, reserva); 
        finalizada.notificar(notificador, reserva);
        enCheckin.notificar(notificador, reserva);  
        verify(notificador, times(1)).cancelada(reserva); 
        verify(notificador, times(1)).confirmada(reserva); 
        verify(notificador, times(1)).enCurso(reserva); 
        verify(notificador, times(1)).finalizada(reserva); 
        verify(notificador, times(1)).enCheckin(reserva); 
    }
}
