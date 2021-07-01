package com.ejemplo.streams;

import java.util.ArrayList;
import java.util.List;

//Para el procesamiento en paralelo, (ejecuciones con hilos).
//No recomendable para usos con Java EE container, (p.e. servidores de aplicaciones con JPA, etc).
//Mas valido para aplicaciones de escritorio o batch.
public class ParallelStreamsApp {
	
	private List<Integer> numeros;
	
	public void llenar() {
		
		numeros = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			
			numeros.add(i);
		}
	}
	
	public void probarStream() {
		
		numeros.stream().forEach(System.out::println);
	}
	
	public void probarParalelo() {
		
		numeros.parallelStream().forEach(System.out::println);
	}

	public static void main(String[] args) {

		ParallelStreamsApp app = new ParallelStreamsApp();
		
		app.llenar();
		
		app.probarStream();
		
		System.out.println("Paralelo:");
		app.probarParalelo();
	}

}
