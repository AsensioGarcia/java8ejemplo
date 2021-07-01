package com.ejemplo.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

//Permite las llamadas asincronas, evitando el uso de future, callback, etc.
//Estas llamadas asincronas desatascan el hilo principal.
public class RxJavaApp {

	private List<Integer> lista1;
	private List<Integer> lista2;
	
	public RxJavaApp() {
		
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		
		this.llenarListas();
	}
	
	public void llenarListas() {
		
		for(int i=0; i<1000; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}
	
	public void buscar() {
		
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		//La busqueda la hara de forma asincrona, con lo que buscara en las 2 listas 
		//de 1000 posiciones y no atascara el hilo principal de ejecucion:
	/*	Observable.merge(obs1, obs2).subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer numero) {
				
				if(numero == 1) {
					
					System.out.println("Es el numero: "+numero);
				}
			}
			
		});
	*/	
		//Lo de arriba ejecuta una expresion funcional, se puede usar un lambda:
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(System.out::println);
		
		//Un lambda man complejo:
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(x -> {
			if(x == 1) {
				
				System.out.println("Es el numero: "+x);
			}
			
		});
	}
	
	public static void main(String[] args) {

		List<String> lista = new ArrayList<>();
		
		lista.add("Cadena1");
		lista.add("Cadena2");
		lista.add("Cadena3");
		
		//Definimos el objeto a observar:
		Observable<String> obs = Observable.from(lista);
		
		//Subscribimos un observador, (subscriptor) al objeto anterior:
		obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				
				System.out.println(elemento);
			}
		});
		
		RxJavaApp app = new RxJavaApp();
		
		app.buscar();
 	}

}
