package tp.BusquedaEnElCatalogo;

// Que porcentaje del catalogo depende de un operador
public class ExposicionOperador {
    private final String operador;
    private final float porcentaje;

    public ExposicionOperador(String operador, float porcentaje) {
        this.operador = operador;
        this.porcentaje = porcentaje;
    }

    public String getOperador() {
        return operador;
    }

    public float getPorcentaje() {
        return porcentaje;
    }
}
