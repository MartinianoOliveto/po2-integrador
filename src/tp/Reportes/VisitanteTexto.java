package tp.Reportes;

public class VisitanteTexto implements Visitante{
    private ExportadorTextoAPI api; 
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
