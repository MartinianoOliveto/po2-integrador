package tp.Reportes;

import java.util.HashMap;

public class ReporteServicios extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
    public HashMap<ItemCatalogo, Integer> serviciosMasreservados(){
        catalogo.serviciosMasReservados(); 
    }
}
