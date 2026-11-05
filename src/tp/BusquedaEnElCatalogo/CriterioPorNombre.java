package tp.BusquedaEnElCatalogo;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioPorNombre implements Criterio{
    private final String texto;
    
    public CriterioPorNombre(String texto){
        this.texto = texto.toLowerCase();
    }
    
    @Override
    public boolean cumple(IItemCatalogo item){
        return (item.getNombre()).toLowerCase().contains(texto);
    }

}
