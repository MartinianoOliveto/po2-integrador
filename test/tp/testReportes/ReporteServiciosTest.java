package tp.testReportes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.Reportes.*;
import tp.BusquedaEnElCatalogo.Catalogo;
import tp.CatalogoDeServiciosYPaquetes.*; 

public class ReporteServiciosTest {
    private ReporteServicios s; 
    private Catalogo c; 
    private VisitanteTexto vt; 
    private VisitanteCSV vc; 
    private VisitanteHTML vh;
    private List<IItemCatalogo> mockMap = new ArrayList<>();

    @BeforeEach 
    public void setUp(){
        c=mock(Catalogo.class); 
        when(c.serviciosMasReservados()).thenReturn(mockMap);
        vt=mock(VisitanteTexto.class); 
        vc=mock(VisitanteCSV.class);
        vh=mock(VisitanteHTML.class);
        s = new ReporteServicios(c); 
    }
    @Test
    public void aceptarVisitantesTest(){
        s.aceptar(vt); 
        s.aceptar(vc);
        s.aceptar(vh);  
        verify(vt,times(1)).visitar(s); 
        verify(vc,times(1)).visitar(s);
        verify(vh,times(1)).visitar(s);  
    }
    @Test
    public void serviciosPorCupoTest(){
        List<IItemCatalogo>r = s.serviciosMasReservados(); 
        assertEquals(r,mockMap); 
        verify(c,times(1)).serviciosMasReservados(); 
    }
}
