package tp.testMetodosDePago;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.MetodosDePago.BilleteraVirtual;
import tp.MetodosDePago.BilleteraVirtualAPI;

public class testBilleteraVirtual {
    private BilleteraVirtual b; 
    private BilleteraVirtualAPI api; 

    @BeforeEach
    public void setUp(){
        api = mock(BilleteraVirtualAPI.class); 
        b = new BilleteraVirtual(1000,api); 
    }
    @Test
    public void procesarPagoTest(){
        b.procesarPago();
        verify(api, atLeastOnce()).validarDatos();
        verify(api,atLeastOnce()).reservarFondos();
        verify(api,atLeastOnce()).ejecutarTransaccion();
        verify(api, atLeastOnce()).notificarResultado(); 
    }
}
