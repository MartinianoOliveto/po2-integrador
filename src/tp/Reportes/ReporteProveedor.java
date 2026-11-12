package tp.Reportes;

import java.util.HashMap;

import tp.BusquedaEnElCatalogo.Catalogo;

public class ReporteProveedor extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }

    public HashMap<String, Float> exposicionPorProveedor(){
        return catalogo.exposicionPorProveedor(); 
    }
    public ReporteProveedor(Catalogo c){
        this.catalogo = c; 
    }
}
