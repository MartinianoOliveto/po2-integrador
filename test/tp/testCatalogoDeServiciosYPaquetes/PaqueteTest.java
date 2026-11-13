package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.CatalogoDeServiciosYPaquetes.Paquete;
import tp.CicloDeVidaDeLaReserva.Periodo;

public class PaqueteTest {
 private Paquete paquete;
 private IItemCatalogo componente1;
 private IItemCatalogo componente2;
 private final Periodo noche = Periodo.unDia(LocalDate.of(2026, 12, 10));

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

    @Test
    public void unPaqueteNoTieneCuposReservadosPropios() {
      paquete.agregarComponente(componente1);

      assertEquals(0, paquete.cuposReservados());
    }

    @Test
    public void operadoresJuntaLosDeTodosSusComponentes() {
      List<String> deHotel = new ArrayList<>();
      deHotel.add("Trivago");
      List<String> deMuseo = new ArrayList<>();
      deMuseo.add("Turismo BA");
      when(componente1.operadores()).thenReturn(deHotel);
      when(componente2.operadores()).thenReturn(deMuseo);
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      List<String> esperados = new ArrayList<>();
      esperados.add("Trivago");
      esperados.add("Turismo BA");
      assertEquals(esperados, paquete.operadores());
    }

    @Test
    public void bloquearCupoBloqueaElCupoDeTodosSusComponentes() {
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      paquete.bloquearCupo(noche);

      verify(componente1).bloquearCupo(noche);
      verify(componente2).bloquearCupo(noche);
    }

    @Test
    public void siUnComponenteNoTieneCupoSeLiberaLoQueYaSeHabiaBloqueado() {
      doThrow(new RuntimeException("No hay cupo disponible")).when(componente2).bloquearCupo(noche);
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      assertThrows(RuntimeException.class, () -> paquete.bloquearCupo(noche));

      verify(componente1).liberarCupo(noche);            // si ya estaba bloqueado hago el rollback
      verify(componente2, never()).liberarCupo(noche);   // nunca llego a bloquearse
    }

    @Test
    public void liberarCupoLiberaElCupoDeTodosSusComponentes() {
      paquete.agregarComponente(componente1);
      paquete.agregarComponente(componente2);

      paquete.liberarCupo(noche);

      verify(componente1).liberarCupo(noche);
      verify(componente2).liberarCupo(noche);
    }

}
