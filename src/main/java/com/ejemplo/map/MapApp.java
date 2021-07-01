package com.ejemplo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapApp {

	private Map<Integer,String> map;
	
	public void poblar() {
		
		map = new HashMap<>();
		
		map.put(1, "Juan");
		map.put(2, "Pedro");
		map.put(3, "Paco");
	}
	
	//En la version 1.7 y anteriores habia que recorrer un Map a traves de un entrySet y un bucle for:
	public void imprimir_v7() {
		
		for(Entry<Integer,String> e : map.entrySet()) {
			
			System.out.println("Llave: " + e.getKey() + " Valor: "+ e.getValue());
		}
	}
	
	//En la version de java 1.8:
	public void imprimir_v8() {
		
		System.out.println("Con lambas:");
		map.forEach((k,v)->System.out.println("Llave: " + k + " Valor: "+ v));
		
		System.out.println("Con referencia a metodos:");
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void insertarSiAusente() {
		
		map.putIfAbsent(4, "Andres");//Como no esta, la añadira
		map.putIfAbsent(2, "Pedro_bis");//Esta no la añadira
	}

	public void operarSiPresente() {
		
		map.computeIfPresent(3, (k,v)-> k + v);
		
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		
		String valor = map.getOrDefault(5, "Valor por defecto");
		
		System.out.println("Valor obtenerOrPredeterminado: " + valor);
	}
	
	public void recolectar() {
		
		//Creamos un mapa con las cadenas que contengan Pa:
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e->e.getValue().contains("Pa"))
				.collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
		
		mapaRecolectado.forEach((k,v)->System.out.println("Llave: " + k + " Valor: "+ v));
	}

	public static void main(String[] args) {
		
		MapApp app = new MapApp();
		
		app.poblar();
		
		System.out.println("Recorrer map version java 1.7:");
		app.imprimir_v7();
		
		app.insertarSiAusente();
		app.operarSiPresente();
		app.obtenerOrPredeterminado();
		
		System.out.println("Recorrer map version java 1.8:");
		app.imprimir_v8();
		
		app.recolectar();
	}

}
