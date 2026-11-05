package tp.BusquedaEnElCatalogo;

public class CriterioPorPrecioMaximo implements Criterio{
    private final double precioMaximo;
    
    public CriterioPorPrecioMaximo(double precioMaximo){
        this.precioMaximo = precioMaximo;
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        return item.getPrecioBase().compareTo(precioMaximo) <= 0;
    }

}
