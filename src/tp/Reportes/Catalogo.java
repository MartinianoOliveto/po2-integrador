package tp.Reportes;

import java.util.HashMap;
import java.util.List;

public class Catalogo {
    public List<ItemCatalogo> serviciosMasreservados(); 
    /*Ordena los items del catalogo por cantidad de unidades/reservas vendidas en un periodo.
    Incluye el precio promedio efectivamente cobrado, que puede diferir del precio base si se aplicaron descuentos de paquete */
    public List<ItemCatalogo> serviciosPorCupo();
    /*Cupos totales, reservados y libres por categoria y periodo
     */
    public HashMap<String, Float> exposicionPorProveedor();
    /*Que porcentaje del catalogo depende de cada oeprador, para medir riesgo de concentracion*/ 
}
