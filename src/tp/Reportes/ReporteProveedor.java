package tp.Reportes;

import java.util.HashMap;

public class ReporteProveedor extends Reporte{

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this); 
    }

    public HashMap<String, Float> exposicionPorProveedor(){
        catalogo.exposicionPorProveedor(); 
    }
}
