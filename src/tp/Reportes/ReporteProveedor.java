package tp.Reportes;

public class ReporteProveedor extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
}
