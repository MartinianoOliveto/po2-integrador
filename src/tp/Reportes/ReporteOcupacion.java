package tp.Reportes;
import tp.CatalogoDeServiciosYPaquetes.*;

import java.util.List;

public class ReporteOcupacion extends Reporte{
    
    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
    
    public List<IItemCatalogo> serviciosPorCupo(){
        return catalogo.serviciosPorCupo(); 
    }
}
