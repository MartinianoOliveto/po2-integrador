package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.NotificacionesReserva.*;

public class testDTVoucher {
    private GeneradorVoucher v;
    private DTVoucher dtv; 

    @BeforeEach 
    public void setUp(){
        v=mock(GeneradorVoucher.class); 
        dtv=new DTVoucher(v); 
    }
    @Test 
    public void finalizadaTest(){
        dtv.finalizada();
        verify(v,times(1)).actualizar(); 
    }
    @Test
    public void confirmadaNoHaceNadaTest(){
        dtv.confirmada();
        verify(v,never()).actualizar(); 
    }
    @Test
    public void enCheckinNoHaceNadaTest(){
        dtv.enCheckin();
        verify(v,never()).actualizar(); 
    }
    @Test
    public void enCursoNoHaceNadaTest(){
        dtv.enCurso();
        verify(v,never()).actualizar(); 
    }
    @Test
    public void canceladaNoHaceNadaTest(){
        dtv.confirmada();
        verify(v,never()).actualizar(); 
    }
    
}
