package tp.testMetodosDePago;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.MetodosDePago.*;

public class testTarjetaInternacional {
    private TarjetaInternacional t; 
    private Banco bancoProvincia; 

    @BeforeEach
    public void setUp(){
        bancoProvincia = mock(Banco.class);
        t = new TarjetaInternacional("5547 3051 2647 8512", 416, "2020/07", bancoProvincia);
    }
    @Test 
    public void procesarPagoTest(){
        t.procesarPago();
        verify(bancoProvincia, atLeastOnce()).preautorizar(); 
        verify(bancoProvincia,atLeastOnce()).validarDatos(t);
        verify(bancoProvincia,atLeastOnce()).ejecutarTransaccion();
        verify(bancoProvincia,atLeastOnce()).notificar();
    }
    //agregar al uml los mensajes del banco
}
