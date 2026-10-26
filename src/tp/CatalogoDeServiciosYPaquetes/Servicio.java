package tp.CatalogoDeServiciosYPaquetes;

public class Servicio implements IItemCatalogo{
 private String nombre;
 private int id; 
 private String descripcion; 
 private String operador;
 private String categoria;
 private double precioBase;
 private double descuentoPromocional; 
// LEAF
 public Servicio (String nombre, int id, String descripcion, String operador, String categoria, double precioBase, double descuentoPromocional) {
  this.nombre = nombre; 
  this.id = id;
  this.descripcion = descripcion;
  this.operador = operador;
  this.categoria = categoria;
  this.precioBase = precioBase;
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
  return precioBase;
 }

 @Override

 public double getPrecioFinal() {
  return this.getPrecioBase() * (1 - descuentoPromocional); 
 }
}
