package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioPorDisponibilidad implements Criterio{

    @Override
    public boolean cumple(IItemCatalogo item){
        return item.tieneDisponibilidad();
    }
}
