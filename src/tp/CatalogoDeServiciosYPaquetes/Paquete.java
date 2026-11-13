package tp.CatalogoDeServiciosYPaquetes;

import java.util.ArrayList;
import java.util.List;

import tp.CicloDeVidaDeLaReserva.Periodo;

public class Paquete implements IItemCatalogo{
  private String nombre;
  private String descripcion;
  private double descuentoPromocional;
  private List <IItemCatalogo> componentes = new ArrayList<>(); 
  // COMPOSITE 
  public Paquete(String nombre, String descripcion, double descuentoPromocional){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.descuentoPromocional = descuentoPromocional/100;
  }

  @Override
   public String getNombre() {
   return nombre; 
  }

 @Override
  public String getDescripcion() {
  return descripcion; 
 }

 @Override

  public double getPrecioBase() {
  double precioBase = 0;
  for (IItemCatalogo componente : componentes) {
	        precioBase += componente.getPrecioBase();
	    }
	    return precioBase;
	}
 @Override

  public double getPrecioFinal() {
  return this.getPrecioBase() * (1 - descuentoPromocional);
 }
 
  public void agregarComponente(IItemCatalogo componente) {
  componentes.add(componente);
 }

  public void quitarComponente(IItemCatalogo componente) {
  componentes.remove(componente);
}

 @Override
  public void bloquearCupo(Periodo periodo) {
  List<IItemCatalogo> bloqueados = new ArrayList<>();
  try {
    for (IItemCatalogo componente : componentes) {
      componente.bloquearCupo(periodo);
      bloqueados.add(componente);
    }
  } catch (RuntimeException e) {
    for (IItemCatalogo componente : bloqueados) {
      componente.liberarCupo(periodo);
    }
    throw e;
  }
 }

 @Override
  public void liberarCupo(Periodo periodo) {
  for (IItemCatalogo componente : componentes) {
    componente.liberarCupo(periodo);
  }
 }

 @Override
  public boolean perteneceACategoria(Categoria categoria) {
  return componentes.stream().anyMatch(componente -> componente.perteneceACategoria(categoria));
 }

 @Override
  public boolean tieneDisponibilidad() { // Obviamente chequeo que no este vacia primero (shortcircuit)
  return !componentes.isEmpty() && componentes.stream().allMatch(componente -> componente.tieneDisponibilidad());
 }

 @Override
  public int cuposReservados() { // El paquete no tiene cupo propio y hoy la Reserva no acepta paquetes
  return 0;
 }

 @Override
  public List<String> operadores() { // Un paquete depende de los operadores de todos sus componentes
  List<String> operadores = new ArrayList<>();
  for (IItemCatalogo componente : componentes) {
    operadores.addAll(componente.operadores());
  }
  return operadores;
 }


}

