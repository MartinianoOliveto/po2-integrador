package tp.testMetodosDePago;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.MetodosDePago.TransferenciaBancaria;
import tp.MetodosDePago.TransferenciaBancariaAPI;

public class testTransferenciaBancaria {
    private TransferenciaBancaria tb; 
    private TransferenciaBancariaAPI api; 
     
    @BeforeEach
    public void setUp(){
        api = mock(TransferenciaBancariaAPI.class); 
        tb = new TransferenciaBancaria("cbu","alias",1000,api); 
    }
    @Test 
    public void procesarPagoTest(){
        tb.procesarPago();
        verify(api,atLeastOnce()).validarDatos();
        verify(api,atLeastOnce()).ejecutarTransaccion();
        verify(api,atLeastOnce()).notificarResultado(); 
    }


}
