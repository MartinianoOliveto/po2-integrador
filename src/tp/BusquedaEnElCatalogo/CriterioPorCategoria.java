package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.Categoria;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioPorCategoria implements Criterio{
    private final Categoria categoria;
    
    public CriterioPorCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        return item.perteneceACategoria(categoria);
    }
}
