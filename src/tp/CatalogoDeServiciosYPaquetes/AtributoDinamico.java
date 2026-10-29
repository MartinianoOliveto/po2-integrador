package tp.CatalogoDeServiciosYPaquetes;

public class AtributoDinamico<T> {
 private String nombre; 
 private boolean indicadorDeObligatoriedad; 
 private ITipoDeValor<T> tipo; 
 private T valor;

 public AtributoDinamico (String nombre, boolean indicadorDeObligatoriedad, ITipoDeValor<T> tipo ){
  this.nombre = nombre;
  this.indicadorDeObligatoriedad = indicadorDeObligatoriedad;
  this.tipo = tipo;
 }

 public void setValor(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return this.valor;
    }

    public void validar() {
     if (this.indicadorDeObligatoriedad && this.valor == null) {
      throw new RuntimeException("Falta el valor del atributo obligatorio: " + this.nombre);
        }
        if (valor != null) {
         tipo.validarTipo(valor); 
    }
    }
}

 
