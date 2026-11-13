package tp.testReportes;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.BusquedaEnElCatalogo.ExposicionOperador;
import tp.Reportes.*; 

public class VisitanteHTMLTest {
    private ReporteServicios s; 
    private List<IItemCatalogo> mockMap = new ArrayList<>();  
    private ReporteOcupacion o; 
    private ReporteProveedor p; 
    private List<ExposicionOperador> mockMap2 = new ArrayList<>(); 
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

