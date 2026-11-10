package tp.testNotificacionesReserva;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.NotificacionesReserva.*;

public class testDTFidelizacion {
    private Fidelizacion f; 
    private DTFidelizacion dtf; 
    
    @BeforeEach
    public void setUp(){
        f=mock(Fidelizacion.class); 
        dtf=new DTFidelizacion(f); 
    }
    
    @Test 
    public void canceladaActualizaTest(){
        dtf.cancelada();
        verify(f,times(1)).actualizar(); 
    }
    @Test
    public void confirmadaNoHaceNadaTest(){
        dtf.confirmada();
        verify(f,never()).actualizar(); 
    }
    @Test
    public void enCheckinNoHaceNadaTest(){
        dtf.enCheckin();
        verify(f,never()).actualizar(); 
    }
    @Test
    public void enCursoNoHaceNadaTest(){
        dtf.enCurso();
        verify(f,never()).actualizar(); 
    }
    @Test
    public void finzalizadaNoHaceNadaTest(){
        dtf.cancelada();
        verify(f,never()).actualizar(); 
    }
}
