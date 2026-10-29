package tp.NotificacionesReserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testReserva {
    private Reserva r;  
    private DT_Notificador dtn; 
    private DT_Generador_Voucher dtg;
    private DT_Fidelizacion dtf; 


    @BeforeEach
    public void setUp(){
        dtn = mock(DT_Notificador.class); 
        dtg = mock(DT_Generador_Voucher.class);
        dtf = mock(DT_Fidelizacion.class); 
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


