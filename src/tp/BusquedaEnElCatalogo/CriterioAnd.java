package tp.BusquedaEnElCatalogo;

import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public class CriterioAnd implements Criterio{
    private final List<Criterio> criterios;

    public CriterioAnd(List<Criterio> criterios){
        this.criterios = criterios;
    }

    @Override
    public boolean cumple(IItemCatalogo item){
        return criterios.stream().allMatch(criterio -> criterio.cumple(item));
    }

}
