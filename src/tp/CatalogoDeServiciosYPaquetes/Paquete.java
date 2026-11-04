package tp.CatalogoDeServiciosYPaquetes;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements IItemCatalogo{
  private String nombre;
  private String descripcion;
  private double descuentoPromocional;
  private List <IItemCatalogo> componentes = new ArrayList(); 
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


}

