package tp.CatalogoDeServiciosYPaquetes;

import java.util.List;

import tp.CicloDeVidaDeLaReserva.Periodo;

public interface IItemCatalogo {
 public String getNombre(); 
 public String getDescripcion(); 
 public double getPrecioFinal(); 
 public double getPrecioBase(); 
 public void bloquearCupo(Periodo periodo);
 public void liberarCupo(Periodo periodo);
 public boolean perteneceACategoria(Categoria categoria);
 public boolean tieneDisponibilidad();
 public int cuposReservados();
 public List<String> operadores();
}
