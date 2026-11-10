package tp.testNotificacionesReserva;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.*;
import tp.NotificacionesReserva.*;

public class testGeneradorVoucher {
    private Reserva r;
    private GeneradorVoucher g; 
    private GeneradorVoucherAPI api; 

    @BeforeEach
    public void setUp(){
        r=mock(Reserva.class);
        api=mock(GeneradorVoucherAPI.class); 
        g=new GeneradorVoucher(api); 
    }
    @Test 
    public void actualizarTest(){
        g.actualizar(r); 
        verify(api,times(1)).generarVoucher(r); 
    }
}
