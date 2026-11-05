package tp.BusquedaEnElCatalogo;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

public abstract class CriterioCompuesto implements Criterio{
    private final List<Criterio> criterios = new ArrayList<Criterio>();

    public CriterioCompuesto(Criterio criterios){
        this.criterios = criterios;
    }
    
    public List<Criterio> getCriterios(){
        return criterios;
    }

}
