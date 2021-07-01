package com.ejemplo.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

	private List<String> lista;
	private List<String> numeros;
	
	public StreamsApp() {
		
		lista = new ArrayList<>();
		
		lista.add("Manuel");
		lista.add("Juan");
		lista.add("Carlos");
		lista.add("Miguel");
		
		numeros = new ArrayList<>();
		
		numeros.add("1");
		numeros.add("2");
	}
	
	public void filtrar() {
		
		System.out.println("Vamos a filtrar todos los elementos que empiecen por M, usando el metodo stream:");
		lista.stream().filter(x->x.startsWith("M")).forEach(System.out::println);
	}
	
	public void ordenar() {
		
		System.out.println("Ordenamos de forma descendente:");
		lista.stream().sorted((x,y)->y.compareToIgnoreCase(x)).forEach(System.out::println);
	}
	
	public void transformar() {
		
		System.out.println("Vamos a transformar a mayusculas todos los elementos:");
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//Si queremos transformar ahora la lista de numeros en enteros y sumarle uno a cada uno, de la manera tradicional:
		for(String numero:numeros) {
			
			int num = Integer.parseInt(numero)+1;
			System.out.println(num);
		}
		
		System.out.println("Vamos a transformar la lista de numeros con la api stream:");
		numeros.stream().map(x->Integer.parseInt(x)+1).forEach(System.out::println);
	}
	
	public void limitar() {
		System.out.println("Limitamos a 2 primeros elementos:");
		lista.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar() {
		
		long longitud = lista.stream().count();
		
		System.out.println("Longitud de la lista: "+ longitud);
	}

	public static void main(String[] args) {
		
		StreamsApp app = new StreamsApp();
		
		app.filtrar();
		
		app.ordenar();
		
		app.transformar();
		
		app.limitar();
		
		app.contar();
	}

}
