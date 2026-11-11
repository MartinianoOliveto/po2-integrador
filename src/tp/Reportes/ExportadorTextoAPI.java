package tp.Reportes;

import java.util.HashMap;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public interface ExportadorTextoAPI {
    public void exportarReporteProveedor(HashMap<String,Float> m); 
    public void exportarReporteOcupacion(List<IItemCatalogo>l); 
    public void exportarReporteServicios(HashMap<IItemCatalogo,Integer>n); 

}
