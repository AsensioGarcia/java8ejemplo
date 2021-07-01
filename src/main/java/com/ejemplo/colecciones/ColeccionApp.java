package com.ejemplo.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista() {
		
		lista = new ArrayList<>();
		
		lista.add("Cadena3");
		lista.add("Cadena1");
		lista.add("Cadena2");
	}
	
	public void usarForEach() {
		
		//Versiones previas a la 1.8:
		for(String elemento:lista) {
			
			System.out.println(elemento);
		}
		
		//Con expresiones Lambda, Consumer es una interfaz funcional:
		lista.forEach(p1->System.out.println("En el lambda: "+p1));
		
		//Con referencias a metodos:
		lista.forEach(System.out::println);
	}
	
	public void usarRemoveIf() {
		
		//De la manera previa a la version 1.8:
		Iterator<String> it = lista.iterator();
		
		while(it.hasNext()) {
			
			if(it.next().equalsIgnoreCase("Cadena1")) {
				
				it.remove();
			}
		}
		
		System.out.println(lista.toString());
		
		//Con lambda, se usa Predicate, los predicados se sustituyen con una lambda:
		lista.removeIf(x->x.equalsIgnoreCase("Cadena2"));
		
		System.out.println("Con lambda: " + lista.toString());
		
		//Con referencia a metodos:
		lista.removeIf("Cadena3"::equalsIgnoreCase);
		System.out.println("Con referencia a metodos: " + lista.toString());
		
	}
	
	public void usarSort() {
		
		//Con Lambda:
		lista.sort((x,y)->x.compareToIgnoreCase(y));
		System.out.println("SORT con lambda: " + lista.toString());
		
		//Con referencia a metodo:
		lista.sort(String::compareToIgnoreCase);
		System.out.println("SORT con referencia a metodos: " + lista.toString());
	}
	
	public static void main(String... args) {
		
		ColeccionApp app = new ColeccionApp();
		
		app.llenarLista();
		
		app.usarForEach();
		
		app.usarSort();
		
		app.usarRemoveIf();
	}

}
