package tp.Reportes;

public class VisitanteHTML implements Visitante{
    private ExportadorHTMLAPI api;

    @Override
    public void visitar(ReporteServicios r) {
        api.exportarReporteServicios(r.serviciosMasReservados()); 
    }

    @Override
    public void visitar(ReporteOcupacion r) {
        api.exportarReporteOcupacion(r.serviciosPorCupo()); 
    }

    @Override
    public void visitar(ReporteProveedor r) {
        api.exportarReporteProveedor(r.exposicionPorProveedor());
    }
    public VisitanteHTML(ExportadorHTMLAPI api){
        this.api = api; 
    }
}
