package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioPorCategoria implements Criterio{
    prviate final Categoria categoria;
    
    public CriterioPorCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        item.perteneceACategoria(categoria);
    }
}
