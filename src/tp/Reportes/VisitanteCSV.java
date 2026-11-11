package tp.Reportes;

public class VisitanteCSV implements Visitante{
    private ExportadorCSVAPI api; 
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

}
