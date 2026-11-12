package tp.testNotificacionesReserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.*;

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
        r = new Reserva(10d); 
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
    public void agregarObservadorRepetidoFallaTest(){
        assertThrows(SujetoException.class, () -> r.agregar(dtn));
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
    public void eliminarObservadorQueNoEstaSuscritoNoRompe(){
        r.remover(dtg); 
        assertDoesNotThrow(()->r.remover(dtg)); 
    }
   /*  @Test 
   //Todos reciben la notificacion
     public void notificarCancelacion(){
        r.cancelar(); 
        verify(dtn,times(1)).actualizar(r); 
        verify(dtg,times(1)).actualizar(r);
        verify(dtf,times(1)).actualizar(r);
    }*/
    //Voy a testear que se notifiquen las transiciones validas 
    @Test 
    public void transicionValidaSolicitudPendienteACanceladaTest(){
        r.cancelar();
        verify(dtn,times(1)).actualizar(r); 
        verify(dtg,times(1)).actualizar(r);
        verify(dtf,times(1)).actualizar(r);
    }
    @Test 
    public void transicionInvalidaSolicitudPendienteACheckinTest(){
        assertThrows(ReservaException.class,()->r.checkin());
        verify(dtn,never()).actualizar(r);
        verify(dtg,never()).actualizar(r);
        verify(dtf,never()).actualizar(r);
    }
    //Este test no pasa, ya que depende de los items, revisar cuando este integrado 
    //Pero aca voy a verificar que se hagan las transiciones validas 
    //Deberia chequear TODAS las transiciones invalidas y testearlas, pero voy a seguir con otros modulos
    @Test 
    public void notificaEnTransicionesValidasTest(){
        r.confirmar();
        r.checkin(); 
        r.iniciar(); 
        verify(dtn,times(3)).actualizar(r); 
        verify(dtg,times(3)).actualizar(r); 
        verify(dtf,times(3)).actualizar(r); 
    }
}


