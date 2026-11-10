package tp.testNotificacionesReserva;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.*;

public class testFidelizacion {
    private Fidelizacion f; 
    private Reserva r;
    private GeneradorCuponAPI api;
    
    @BeforeEach 
    public void setUp(){
        r=mock(Reserva.class);
        api=mock(GeneradorCuponAPI.class); 
        f=new Fidelizacion(api); 
    }
    @Test 
    public void actualizarTest(){
        f.actualizar(r); 
        verify(api,times(1)).generarCupon(r); 
    }
}
