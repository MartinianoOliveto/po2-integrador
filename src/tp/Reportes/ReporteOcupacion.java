package tp.Reportes;

public class ReporteOcupacion extends Reporte{
    
    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
}
