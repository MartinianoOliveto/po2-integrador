package tp.testMetodosDePago;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.MetodosDePago.*;

public class testTarjetaInternacional {
    private TarjetaInternacional t; 
    private TarjetaInternacionalAPI api; 

    @BeforeEach
    public void setUp(){
        api = mock(TarjetaInternacionalAPI.class);
        t = new TarjetaInternacional("5547 3051 2647 8512", 416, "2020/07", api);
    }
    @Test 
    public void procesarPagoTest(){
        t.procesarPago();
        verify(api,times(1)).validarDatos(t);
        verify(api, times(1)).reservarFondos(); 
        verify(api,times(1)).ejecutarTransaccion();
        verify(api,times(1)).notificarResultado();
    }
}
