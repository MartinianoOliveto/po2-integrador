package tp.traslado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VipTest {
 private TrasladoVIP trasladoVipMock;
 private Vip vip;
 private Direccion direccion;

 @BeforeEach
public void setUp() {
  trasladoVipMock = mock(TrasladoVIP.class);
  direccion = mock(Direccion.class); 
  vip = new Vip (trasladoVipMock);
  } 

@Test 
public void testVipCalculoCostoDelegadoEntraslado() {
  vip.calcularCosto(1,4,direccion);
  verify(trasladoVipMock,times(1)).calcularCosto(1);
  } 

@Test 
public void testVipDevuelveCostoCalculado(){
  when(trasladoVipMock.calcularCosto(1)).thenReturn(1f);
  float costoVip = vip.calcularCosto(1,4,direccion);
  assertEquals(1, costoVip);
  }
}

