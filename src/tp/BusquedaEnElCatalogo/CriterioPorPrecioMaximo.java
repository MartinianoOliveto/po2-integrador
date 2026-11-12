package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioPorPrecioMaximo implements Criterio{
    private final double precioMaximo;
    
    public CriterioPorPrecioMaximo(double precioMaximo){
        this.precioMaximo = precioMaximo;
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        return item.getPrecioFinal() <= precioMaximo;
    }

}
