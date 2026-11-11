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
    public HashMap<IItemCatalogo,Integer> serviciosMasReservados(){
        return; //rankear por reservas heap que los ordene y despues un map 
    } //Esto aca deberia recibir un periodo como parametro??
    /*Ordena los items del catalogo por cantidad de unidades/reservas vendidas en un periodo.
    Incluye el precio promedio efectivamente cobrado, que puede diferir del precio base si se aplicaron descuentos de paquete */
    public List<IItemCatalogo> serviciosPorCupo(){//Lo deberia tener el calendario 
        return; //filtrar servicios por periodo y y pedirle todos los datos a los que cumplan 
    } //Esto aca deberia recibir un periodo y una categoria??
    /*Cupos totales, reservados y libres por categoria y periodo
     */
    
    public HashMap<String, Float> exposicionPorProveedor(){ //float: getPrecioFinal String: getDescripcion
        return; 
    } 
    /*Que porcentaje del catalogo depende de cada oeprador, para medir riesgo de concentracion*/ 
}
