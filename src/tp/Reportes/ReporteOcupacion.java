package tp.Reportes;

import java.util.List;

public class ReporteOcupacion extends Reporte{
    
    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }
    //Aca hay que ver si estos metodos los puedo pasar a la superclase Reporte, y hacer un template 
    //Si hay distintos tipo
    public List<ItemCatalogo> serviciosPorCupo(){
        catalogo.serviciosPorCupo(); 
    }
}
