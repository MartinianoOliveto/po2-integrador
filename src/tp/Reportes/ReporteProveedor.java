package tp.Reportes;

import java.util.List;

import tp.BusquedaEnElCatalogo.Catalogo;
import tp.BusquedaEnElCatalogo.ExposicionOperador;

public class ReporteProveedor extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }

    public List<ExposicionOperador> exposicionPorProveedor(){
        return catalogo.exposicionPorProveedor(); 
    }
    public ReporteProveedor(Catalogo c){
        this.catalogo = c; 
    }
}
