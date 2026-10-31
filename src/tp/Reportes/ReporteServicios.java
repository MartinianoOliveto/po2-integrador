package tp.Reportes;

public class ReporteServicios extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }

}
