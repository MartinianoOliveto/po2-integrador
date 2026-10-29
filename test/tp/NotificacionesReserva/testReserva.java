package tp.NotificacionesReserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testReserva {
    private Reserva r;  
    private DTFidelizacion dtn; 
    private DTVoucher dtg;
    private DTNotificador dtf; 


    @BeforeEach
    public void setUp(){
        dtn = mock(DTFidelizacion.class); 
        dtg = mock(DTVoucher.class);
        dtf = mock(DTNotificador.class); 
        r = new Reserva(); 
        r.agregar(dtn);
        r.agregar(dtg);
        r.agregar(dtf);
    }
    @Test 
    public void agregandoObservadorTest(){
        assertTrue(r.getObservadores().contains(dtg));
        assertTrue(r.getObservadores().contains(dtf));
        assertTrue(r.getObservadores().contains(dtn));
    }
    @Test 
    public void eliminandoObservadoresTest(){
        r.remover(dtg);
        assertFalse(r.getObservadores().contains(dtg));
        assertTrue(r.getObservadores().contains(dtf));
        assertTrue(r.getObservadores().contains(dtn));
        assertTrue(r.getObservadores().size()==2);
    }
    @Test 
    public void notificarTest(){
        r.notificar(r);
        verify(dtn,times(1)).actualizar(r); 
        verify(dtg,times(1)).actualizar(r);
        verify(dtf,times(1)).actualizar(r);
    }
}


