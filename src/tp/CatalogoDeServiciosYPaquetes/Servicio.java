package tp.CatalogoDeServiciosYPaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tp.CicloDeVidaDeLaReserva.CalendarioDeCupos;
import tp.CicloDeVidaDeLaReserva.Periodo;

public class Servicio implements IItemCatalogo{
 private String nombre;
 private int id; 
 private String descripcion; 
 private String operador;
 private Categoria categoria;
 private double precioBase;
 private double descuentoPromocional;
 private final CalendarioDeCupos cupos = new CalendarioDeCupos(); // Colaborador que sugirio el profe
 private List<AtributoDinamico> atributosDinamicos = new ArrayList<>();
// LEAF
 public Servicio (String nombre, int id, String descripcion, String operador, Categoria categoria, double precioBase, double descuentoPromocional) {
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

 @Override 
 public void bloquearCupo(Periodo periodo){
    cupos.bloquear(periodo);
 }

 @Override
 public void liberarCupo(Periodo periodo) {
        cupos.liberar(periodo);
 }

 public void agregarAtributo(AtributoDinamico atributo) {
    this.atributosDinamicos.add(atributo);
}

 public int cuposDisponibles(LocalDate dia) {
    return cupos.disponibles(dia);
 }

 public boolean hayCupo(Periodo periodo) {
    return cupos.hayCupo(periodo);
 }

 
 @Override
 public boolean perteneceACategoria(Categoria categoria) {
    return this.categoria == categoria;
 }

 @Override
 public boolean tieneDisponibilidad() {
    return cupos.tieneCupoEnAlgunaFecha();
 }


public void validar() {
    if (this.nombre == null) {
        throw new RuntimeException("Falta el valor del atributo obligatorio: nombre");
    }
    if (this.categoria == null) {
        throw new RuntimeException("Falta el valor del atributo obligatorio: categoria");
    }
        for (AtributoDinamico atributo : this.atributosDinamicos) {
        atributo.validar();
    }
}
}