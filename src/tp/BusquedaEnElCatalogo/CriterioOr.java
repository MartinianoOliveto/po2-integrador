package tp.BusquedaEnElCatalogo;

import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioOr implements Criterio{

    private final List<Criterio> criterios;

    public CriterioOr(List<Criterio> criterios){
        this.criterios = criterios;
    }

    @Override
    public boolean cumple(IItemCatalogo item){
        return criterios.stream().anyMatch(criterio -> criterio.cumple(item));
    }
}
