package com.ejemplo.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighOrderApp {
	
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function<String, String> funcion, String valor) {
		
		System.out.println(funcion.apply(valor));
	}
	
	public Function<String, String> mostrar(String mensaje){
		
		return (String x) -> mensaje + x;
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud) {
		
		lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		
		return texto -> texto.length() < longitud;
	}

	public static void main(String[] args) {
		
		HighOrderApp app = new HighOrderApp();
		
		app.imprimir(app.convertirMayusculas, "cadenaminusculas");
		app.imprimir(app.convertirMinusculas, "CADENAMAYUSCULAS");
		
		String respuesta = app.mostrar("Hola ").apply("Pepe");
		System.out.println(respuesta);
		
		List<String> lista = new ArrayList<>();
		lista.add("cadena1");
		lista.add("cadena2");
		lista.add("cadena10");
		
		
		System.out.println("Filtrar:");
		app.filtrar(lista, System.out::println, 8);
	}

}
