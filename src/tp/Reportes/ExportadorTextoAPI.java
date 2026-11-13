package tp.Reportes;

import java.util.List;

import tp.BusquedaEnElCatalogo.ExposicionOperador;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public interface ExportadorTextoAPI {
    public void exportarReporteProveedor(List<ExposicionOperador> m); 
    public void exportarReporteOcupacion(List<IItemCatalogo>l); 
    public void exportarReporteServicios(List<IItemCatalogo> n); 

}
