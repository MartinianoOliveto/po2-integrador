package tp.BusquedaEnElCatalogo;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.*;

public class Catalogo {

    private final List<IItemCatalogo> items = new ArrayList<IItemCatalogo>();
    
    public void agregar(IItemCatalogo item){
        items.add(item);
    }

    public List<IItemCatalogo> buscar(Criterio criterio){
        return items.stream()
                .filter(item -> criterio.cumple(item))
                .toList();
    }

    public List<IItemCatalogo> serviciosMasReservados(){ // de mas a menos cupos reservados
        List<IItemCatalogo> ranking = new ArrayList<IItemCatalogo>();
        for (IItemCatalogo item : items) {
            int posicion = 0;
            while (posicion < ranking.size() && ranking.get(posicion).cuposReservados() >= item.cuposReservados()) {
                posicion++;
            }
            ranking.add(posicion, item); // lo inserto delante del primero que tiene menos
        }
        return ranking;
    }

    public List<IItemCatalogo> serviciosPorCupo(){ // El exportador le pide a cada item sus cupos
        return new ArrayList<IItemCatalogo>(items); // Para no exponer la lista interna
    }
    
    public List<ExposicionOperador> exposicionPorProveedor(){
        List<String> todos = new ArrayList<String>();
        for (IItemCatalogo item : items) {
            todos.addAll(item.operadores());
        }
        List<String> distintos = new ArrayList<String>();
        for (String operador : todos) {
            if (!distintos.contains(operador)) {
                distintos.add(operador);
            }
        }
        List<ExposicionOperador> exposicion = new ArrayList<ExposicionOperador>();
        for (String operador : distintos) {
            exposicion.add(new ExposicionOperador(operador, porcentaje(operador, todos)));
        }
        return exposicion;
    }

    private float porcentaje(String operador, List<String> todos) {
        int cantidad = 0;
        for (String otro : todos) {
            if (otro.equals(operador)) {
                cantidad++;
            }
        }
        return cantidad * 100f / todos.size();
    }
    
}
