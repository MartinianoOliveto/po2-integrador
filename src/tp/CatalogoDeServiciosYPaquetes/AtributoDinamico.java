package tp.CatalogoDeServiciosYPaquetes;

public class AtributoDinamico {
 private String nombre; 
 private boolean indicadorDeObligatoriedad; 
 private ITipoDeValor valorQueAcepta; 

 public AtributoDinamico (String nombre, boolean indicadorDeObligatoriedad, ITipoDeValor valorQueAcepta ){
  this.nombre = nombre;
  this.indicadorDeObligatoriedad = indicadorDeObligatoriedad;
  this.valorQueAcepta = valorQueAcepta;
 }
}
