package tp.testReportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp.BusquedaEnElCatalogo.Catalogo;
import tp.BusquedaEnElCatalogo.ExposicionOperador;
import tp.Reportes.*;

public class ReporteProveedorTest {
    private ReporteProveedor p; 
    private Catalogo c; 
    private VisitanteTexto vt; 
    private VisitanteCSV vc; 
    private VisitanteHTML vh;
    private List<ExposicionOperador> mockMap = new ArrayList<>(); 

    @BeforeEach
    public void setUp(){
        c=mock(Catalogo.class);
        when(c.exposicionPorProveedor()).thenReturn(mockMap); 
        vt=mock(VisitanteTexto.class); 
        vc=mock(VisitanteCSV.class);
        vh=mock(VisitanteHTML.class);
        p = new ReporteProveedor(c);
    }
    @Test
    public void aceptarVisitantesTest(){
        p.aceptar(vt); 
        p.aceptar(vc);
        p.aceptar(vh);  
        verify(vt,times(1)).visitar(p); 
        verify(vc,times(1)).visitar(p);
        verify(vh,times(1)).visitar(p);  
    }
    @Test
    public void serviciosPorCupoTest(){
        List<ExposicionOperador>r = p.exposicionPorProveedor(); 
        assertEquals(r,mockMap); 
        verify(c,times(1)).exposicionPorProveedor(); 
    }
}
