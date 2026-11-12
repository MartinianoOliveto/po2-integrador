package tp.Reportes;

import java.util.HashMap;

import tp.BusquedaEnElCatalogo.Catalogo;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class ReporteServicios extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
    public HashMap<IItemCatalogo, Integer> serviciosMasReservados(){
        return catalogo.serviciosMasReservados(); 
    }
    public ReporteServicios(Catalogo c){
        this.catalogo = c; 
    }
}
