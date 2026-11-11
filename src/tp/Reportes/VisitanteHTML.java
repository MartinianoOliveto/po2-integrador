package tp.Reportes;

public class VisitanteHTML implements Visitante{
    private ExportadorHTMLAPI api;

    @Override
    public void visitar(ReporteServicios r) {

    }

    @Override
    public void visitar(ReporteOcupacion r) {
        //Le solicito los resultados al reporte 
        //Exporto a HTML (como lo modelo??)
    }

    @Override
    public void visitar(ReporteProveedor r) {
        //Le solicito los resultados al reporte 
        //Exporto a HTML (como lo modelo??)
    }
    
}
