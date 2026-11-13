package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import tp.CatalogoDeServiciosYPaquetes.AtributoDinamico;
import tp.CatalogoDeServiciosYPaquetes.Categoria;
import tp.CatalogoDeServiciosYPaquetes.Servicio;
import tp.CicloDeVidaDeLaReserva.Periodo;

public class testServicio {
  private Servicio hotel;

  @BeforeEach 

  public void setUp() {
    hotel = new Servicio("Hotel Central", 1, "Noche en el hotel central", "Trivago", Categoria.ALOJAMIENTO, 1000, 0);
}
  @Test
  public void sinDescuentoElPrecioFinalEsIgualAlBase() {
	  assertEquals(1000, hotel.getPrecioFinal(), 0.001);
}

  @Test
  public void validarFallaSiFaltaElNombre() {
	Servicio sinNombre = new Servicio(null, 1, "Sin nombre", "Trivago", Categoria.ALOJAMIENTO, 1000, 0);

	RuntimeException error = assertThrows(RuntimeException.class, () -> sinNombre.validar());

	assertEquals("Falta el valor del atributo obligatorio: nombre", error.getMessage());
}  

@Test
public void validarNoFallaSiLaListaDeAtributosEstaVacia() {
  assertDoesNotThrow(() -> hotel.validar());
}

@Test
public void validarNoFallaSiLosAtributosSonValidos() {
	AtributoDinamico capacidadMaxima = mock(AtributoDinamico.class);
	AtributoDinamico politicaMascotas = mock(AtributoDinamico.class);
	hotel.agregarAtributo(capacidadMaxima);
	hotel.agregarAtributo(politicaMascotas);

	assertDoesNotThrow(() -> hotel.validar());

	verify(capacidadMaxima).validar();
	verify(politicaMascotas).validar();
}

@Test 

public void DevuelveNombre() {
  assertEquals("Hotel Central", hotel.getNombre());
}

@Test
public void DevuelveDescripcion() {
  assertEquals("Noche en el hotel central", hotel.getDescripcion());
}

@Test
public void cuposReservadosCuentaLosCuposBloqueadosEnSuCalendario() {
  hotel.bloquearCupo(Periodo.unDia(LocalDate.of(2026, 12, 10)));
  hotel.bloquearCupo(Periodo.unDia(LocalDate.of(2026, 12, 11)));

  assertEquals(2, hotel.cuposReservados());
}

@Test
public void operadoresDevuelveSoloSuOperador() {
  assertEquals(1, hotel.operadores().size());
  assertEquals("Trivago", hotel.operadores().get(0));
}

}
