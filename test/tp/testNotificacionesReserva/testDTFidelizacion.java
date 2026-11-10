package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.*;

public class testDTFidelizacion {
    private Fidelizacion f; 
    private DTFidelizacion dtf; 
    private Reserva r;
    
    @BeforeEach
    public void setUp(){
        f=mock(Fidelizacion.class); 
        dtf=new DTFidelizacion(f); 
        r=mock(Reserva.class); 
    }
    
    @Test 
    public void canceladaActualizaTest(){
        dtf.cancelada(r);
        verify(f,times(1)).actualizar(r); 
    }
    @Test
    public void confirmadaNoHaceNadaTest(){
        dtf.confirmada(r);
        verify(f,never()).actualizar(r); 
    }
    @Test
    public void enCheckinNoHaceNadaTest(){
        dtf.enCheckin(r);
        verify(f,never()).actualizar(r); 
    }
    @Test
    public void enCursoNoHaceNadaTest(){
        dtf.enCurso(r);
        verify(f,never()).actualizar(r); 
    }
    @Test
    public void finzalizadaNoHaceNadaTest(){
        dtf.finalizada(r);
        verify(f,never()).actualizar(r); 
    }
    @Test 
    public void DTDelegaEnLaReservaCuandoRecibeNotificacion(){
        dtf.actualizar(r); 
        verify(r,times(1)).delegarNotificacion(dtf); 
    }
}
