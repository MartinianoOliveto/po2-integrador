package tp.testReportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.Catalogo;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.Reportes.*;

public class ReporteOcupacionTest {
    private ReporteOcupacion o; 
    private Catalogo c; 
    private VisitanteTexto vt; 
    private VisitanteCSV vc; 
    private VisitanteHTML vh;
    private List<IItemCatalogo> listaMock = new ArrayList<>();
    
    @BeforeEach
    public void setUp(){
        c=mock(Catalogo.class);
        when(c.serviciosPorCupo()).thenReturn(listaMock); 
        vt=mock(VisitanteTexto.class); 
        vc=mock(VisitanteCSV.class);
        vh=mock(VisitanteHTML.class);
        o = new ReporteOcupacion(c);
    }
    @Test
    public void aceptarVisitantesTest(){
        o.aceptar(vt); 
        o.aceptar(vc);
        o.aceptar(vh);  
        verify(vt,times(1)).visitar(o); 
        verify(vc,times(1)).visitar(o);
        verify(vh,times(1)).visitar(o);  
    }
    @Test
    public void serviciosPorCupoTest(){
        List<IItemCatalogo>r = o.serviciosPorCupo(); 
        assertEquals(r,listaMock); 
        verify(c,times(1)).serviciosPorCupo(); 
    }
}
