package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public interface Criterio {

    public boolean cumple(IItemCatalogo item);
    
}
