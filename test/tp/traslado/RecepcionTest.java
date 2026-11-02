package tp.traslado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecepcionTest {
private Recepcion recepcion;

@BeforeEach
  public void setUp() {
  recepcion = new Recepcion();   
  }
@Test
public void testRecepcionCalculaCosto(){
  float costo = recepcion.calcularCosto();

  assertEquals(0, costo);
}
}
