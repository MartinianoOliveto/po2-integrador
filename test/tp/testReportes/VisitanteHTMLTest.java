package tp.testReportes;
import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.Reportes.*; 

public class VisitanteHTMLTest {
    private ReporteServicios s; 
    private HashMap<IItemCatalogo,Integer> mockMap = new HashMap<>();  
    private ReporteOcupacion o; 
    private ReporteProveedor p; 
    private HashMap<String,Float> mockMap2 = new HashMap<>(); 
    private VisitanteHTML v; 
    private ExportadorHTMLAPI api;
    
    @BeforeEach 
    public void setUp(){
        s = mock(ReporteServicios.class);
        when(s.serviciosMasReservados()).thenReturn(mockMap);
        o = mock(ReporteOcupacion.class); 
        p = mock(ReporteProveedor.class); 
        when(p.exposicionPorProveedor()).thenReturn(mockMap2); 
        api = mock(ExportadorHTMLAPI.class); 
        v = new VisitanteHTML(api);
    }
    @Test 
    public void visitarReporteServiciosTest(){
        v.visitar(s); 
        verify(api,times(1)).exportarReporteServicios(s.serviciosMasReservados()); 
    }
    @Test 
    public void visitarReporteOcupacionTest(){
        v.visitar(o); 
        verify(api,times(1)).exportarReporteOcupacion(o.serviciosPorCupo());
    }
    @Test 
    public void visitarReporteProveedorTest(){
        v.visitar(p);
        verify(api,times(1)).exportarReporteProveedor(p.exposicionPorProveedor()); 
    }
}

