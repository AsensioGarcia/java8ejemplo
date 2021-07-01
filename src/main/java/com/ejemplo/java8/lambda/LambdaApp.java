package com.ejemplo.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaApp 
{
	
	//Ordenacion de una lista de java 1.7 hacia atras adelante:
	public void ordenarFormaTradicional() {
		
		List<String> lista = new ArrayList<>();
		
		lista.add("Cadena3");
		lista.add("Cadena1");
		lista.add("Cadena2");
		
		//Ordenamos la lista en orden ascendente:
		Collections.sort(lista, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {

				
				return o1.compareTo(o2);//Los ordenara ascendentemente.
			} 
			
		});
		
		//Recorremos la lista para ver que esta ordenada:
		for(String elemento : lista) {
			
			System.out.println(elemento);
		}
	}

	//Ordenacion de una lista en java 1.8 con lambdas:
	public void ordenar() {
		
		List<String>lista = new ArrayList<>();
		
		lista.add("Cadena3");
		lista.add("Cadena1");
		lista.add("Cadena2");
		
		//Comparator es una interfaz funcional.
		//Como si se hiciera: Comparator comp = (String p1, String p2) -> p1.compareTo(p2));
		//Ordenamos la lista en orden ascendente:
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		//Recorremos la lista para ver que esta ordenada:
		for(String elemento : lista) {
			
			System.out.println(elemento);
		}
	}
	
	//Calcular promedio usando una interfaz de manera tradicional:
	public void calcularImperativo() {
		
		Operacion operacion = new Operacion() {
			
			@Override
			public double calcular(double n1, double n2) {
				
				return (n1+n2)/2;
			}
		};
		
		System.out.println(operacion.calcular(2, 3));
	}
	
	//Calcular promedio usando una interfaz con lambdas:
	public void calcularDeclarativo() {
		
		Operacion operacion = (double x, double y) -> (x+y)/2;
		operacion.calcular(2, 3);
			
		System.out.println(operacion.calcular(2, 3));
	}
	
	public void probarSintaxisLambda() {
		
//		Operacion operacion = (double x, double y) -> (x+y)/2;
//		Operacion operacion = (double x, double y) -> {return (x+y)/2;};
/*		Operacion operacion = (double x, double y) -> {
			double a= 2.0 ;
			return (x+y)/2+a;
		};*/
		Operacion operacion = (x, y) -> (x+y)/2;
		
		operacion.calcular(2, 3);
			
		System.out.println(operacion.calcular(2, 3));
		
	}
	
    public static void main( String[] args ){
    	
        LambdaApp app = new LambdaApp();
        
		System.out.println("Forma tradicional de ordenacion, enfoque imperativo:");
        app.ordenarFormaTradicional();
        
		System.out.println("Forma de ordenacion con lambdas, enfoque declarativo:");
        app.ordenar();

		System.out.println("Calcular promedio con interfaz tradicional:");
        app.calcularImperativo();

		System.out.println("Calcular promedio con lambdas:");
        app.calcularDeclarativo();
        
		System.out.println("Probar sintaxis lambdas:");
        app.probarSintaxisLambda();

}
}
