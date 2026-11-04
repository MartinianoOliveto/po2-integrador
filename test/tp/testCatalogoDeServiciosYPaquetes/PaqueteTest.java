package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.CatalogoDeServiciosYPaquetes.Paquete;

public class PaqueteTest {
 private Paquete paquete;
 private IItemCatalogo componente1;
 private IItemCatalogo componente2;

@BeforeEach
 public void setUp() { 
  paquete = new Paquete("Escapada Urbana", "Especial Navidad", 10);

  componente1 = mock(IItemCatalogo.class);
  componente2 = mock(IItemCatalogo.class);
  }

  @Test
    public void verificarQueLlegaMensajeAComponente(){
     paquete.agregarComponente(componente1);
     paquete.agregarComponente(componente2);

     paquete.getPrecioBase();

     verify(componente1, times(1)).getPrecioBase();
     verify(componente2, times(1)).getPrecioBase();
    };

  @Test
    public void calculoDelPrecioDePaquetePrecioBase() {
      when(componente1.getPrecioBase()).thenReturn(1000.0);
      when(componente2.getPrecioBase()).thenReturn(2000.0);
      
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      assertEquals(3000, paquete.getPrecioBase());
    }

  @Test
    public void calculoDelPrecioDePaquetePrecioFinal() {
      when(componente1.getPrecioBase()).thenReturn(11000.0);
      when(componente2.getPrecioBase()).thenReturn(10000.0);
      
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      assertEquals(18900, paquete.getPrecioFinal());
    }  

    @Test
    public void alQuitarUnComponenteNoSeSumaSuPrecioBase() {
      when(componente1.getPrecioBase()).thenReturn(1000.0);
      when(componente2.getPrecioBase()).thenReturn(2000.0);
      
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);
      paquete.quitarComponente (componente1);

      assertEquals(2000, paquete.getPrecioBase());
    }
    @Test 
    public void DevuelveElNombre(){
      assertEquals("Escapada Urbana", paquete.getNombre());
    }
    @Test 
    public void DevuelveLaDescripcion() {
      assertEquals("Especial Navidad", paquete.getDescripcion());
    }

}
