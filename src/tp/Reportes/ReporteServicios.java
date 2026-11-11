package tp.Reportes;

import java.util.HashMap;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class ReporteServicios extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
    public HashMap<IItemCatalogo, Integer> serviciosMasreservados(){
        return catalogo.serviciosMasReservados(); 
    }
}
