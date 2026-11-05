package tp.BusquedaEnElCatalogo;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

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
}
