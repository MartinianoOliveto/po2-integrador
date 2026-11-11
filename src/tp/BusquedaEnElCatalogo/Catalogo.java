package tp.BusquedaEnElCatalogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;

public class Catalogo {

    private final List<IItemCatalogo> items = new ArrayList<IItemCatalogo>();
    
    public void agregar(IItemCatalogo item){
        items.add(item);
    }

    public List<IItemCatalogo> buscar(Criterio criterio){
        return items.stream()
                .filter(item -> criterio.cumple(item))
                .toList();
    }

    //Metodos referidos al punto 2.8 
    public HashMap<IItemCatalogo,Integer> serviciosMasReservados(); //Esto aca deberia recibir un periodo como parametro??
    /*Ordena los items del catalogo por cantidad de unidades/reservas vendidas en un periodo.
    Incluye el precio promedio efectivamente cobrado, que puede diferir del precio base si se aplicaron descuentos de paquete */

    //Este tiene que cambiar de tipo, no se que usar 
    public List<IItemCatalogo> serviciosPorCupo(); //Esto aca deberia recibir un periodo y una categoria??
    /*Cupos totales, reservados y libres por categoria y periodo
     */
    
    public HashMap<String, Float> exposicionPorProveedor(); 
    /*Que porcentaje del catalogo depende de cada oeprador, para medir riesgo de concentracion*/ 
}
