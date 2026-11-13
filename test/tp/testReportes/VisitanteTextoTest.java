package tp.testReportes;

import tp.CatalogoDeServiciosYPaquetes.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.ExposicionOperador;
import tp.Reportes.*;

public class VisitanteTextoTest {
    private VisitanteTexto v;
    private ExportadorTextoAPI apiTexto;
    private ReporteServicios s;
    private ReporteProveedor p; 
    private ReporteOcupacion o; 
    private List<ExposicionOperador> mockMap = new ArrayList<>(); 
    private List<IItemCatalogo> mockMap2 = new ArrayList<>(); 

    @BeforeEach
    public void setUp(){
        s = mock(ReporteServicios.class); 
        p = mock(ReporteProveedor.class);
        o = mock(ReporteOcupacion.class);
        apiTexto = mock(ExportadorTextoAPI.class);  
        when(p.exposicionPorProveedor()).thenReturn(mockMap); 
        when(s.serviciosMasReservados()).thenReturn(mockMap2); 
        v = new VisitanteTexto(apiTexto); 
    }
    @Test 
    public void visitarReporteServiciosTest(){
        v.visitar(s);
        verify(apiTexto,times(1)).exportarReporteServicios(s.serviciosMasReservados());    
    }
    @Test 
    public void visitarReporteOcupacionTest(){
        v.visitar(o);
        verify(apiTexto,times(1)).exportarReporteOcupacion(o.serviciosPorCupo());
    }
    @Test
    public void visitarReporteProveedorTest(){
        v.visitar(p);
        verify(apiTexto,times(1)).exportarReporteProveedor(p.exposicionPorProveedor()); 
    }
    
}
