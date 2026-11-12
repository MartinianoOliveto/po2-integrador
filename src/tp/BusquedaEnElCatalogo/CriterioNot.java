package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioNot implements Criterio{
    private final Criterio criterio;
    
    public CriterioNot(Criterio criterio){
        this.criterio = criterio;
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        return !criterio.cumple(item);
    }
}
