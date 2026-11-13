package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.NotificacionesReserva.*;
import tp.CicloDeVidaDeLaReserva.*;

public class testDTVoucher {
    private GeneradorVoucher v;
    private DTVoucher dtv; 
    private Reserva r; 

    @BeforeEach 
    public void setUp(){
        v=mock(GeneradorVoucher.class); 
        dtv=new DTVoucher(v); 
        r=mock(Reserva.class); 
    }
    @Test 
    public void finalizadaTest(){
        dtv.finalizada(r);
        verify(v,times(1)).actualizar(r); 
    }
    @Test
    public void confirmadaNoHaceNadaTest(){
        dtv.confirmada(r);
        verify(v,never()).actualizar(r); 
    }
    @Test
    public void enCheckinNoHaceNadaTest(){
        dtv.enCheckin(r);
        verify(v,never()).actualizar(r); 
    }
    @Test
    public void enCursoNoHaceNadaTest(){
        dtv.enCurso(r);
        verify(v,never()).actualizar(r); 
    }
    @Test
    public void canceladaNoHaceNadaTest(){
        dtv.cancelada(r);
        verify(v,never()).actualizar(r); 
    }
    @Test 
    public void DTDelegaEnLaReservaCuandoRecibeNotificacion(){
        dtv.actualizar(r); 
        verify(r,times(1)).delegarNotificacion(dtv); 
    }
    
}
