package tp.testReportes;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.ExposicionOperador;
import tp.Reportes.*;
import tp.CatalogoDeServiciosYPaquetes.*; 

public class VisitanteCSVTest {
    private ReporteServicios r; 
    private List<IItemCatalogo> mockMap = new ArrayList<>();  
    private ReporteOcupacion o;
    private ReporteProveedor p; 
    private List<ExposicionOperador> mockMap2 = new ArrayList<>(); 
    private VisitanteCSV v; 
    private ExportadorCSVAPI api; 

    @BeforeEach 
    public void setUp(){
        r = mock(ReporteServicios.class); 
        when(r.serviciosMasReservados()).thenReturn(mockMap);
        o = mock(ReporteOcupacion.class);
        p = mock(ReporteProveedor.class); 
        when(p.exposicionPorProveedor()).thenReturn(mockMap2); 
        api = mock(ExportadorCSVAPI.class);
        v = new VisitanteCSV(api); 
    }
    @Test 
    public void visitarReporteServiciosTest(){
        v.visitar(r); 
        verify(api,times(1)).exportarReporteServicios(r.serviciosMasReservados()); 
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
