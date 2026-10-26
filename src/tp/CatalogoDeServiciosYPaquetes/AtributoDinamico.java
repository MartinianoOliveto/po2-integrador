package tp.CatalogoDeServiciosYPaquetes;

public class AtributoDinamico {
 private String nombre; 
 private boolean indicadorDeObligatoriedad; 
 private ITipoDeValor tipo; 

 public AtributoDinamico (String nombre, boolean indicadorDeObligatoriedad, ITipoDeValor tipo ){
  this.nombre = nombre;
  this.indicadorDeObligatoriedad = indicadorDeObligatoriedad;
  this.tipo = tipo;
 }
}
