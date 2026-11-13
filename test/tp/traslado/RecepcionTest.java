package tp.traslado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecepcionTest {
private Recepcion recepcion;
private Direccion direccion;

@BeforeEach
  public void setUp() {
  recepcion = new Recepcion();   
  direccion = mock(Direccion.class);
  }
@Test
public void testRecepcionCalculaCosto(){
  float costo = recepcion.calcularCosto(10000, 1, direccion);

  assertEquals(0, costo);
  }
}
