package com.ejemplo.methodReference;

import java.util.Arrays;

public class MeRefApp {
	
	//Siempre hay que apoyarse en una interfaz funcional.
	//En java 8 a los metodos referenciados estaticos no deja enviarle parametros, con lo que hay que definirlos sin ellos.
	//Referenciar metodos de una interfaz con otros metodos que implementados e indicamos con operadores lambda o con el operador ::
	public static void referenciarMetodoStatic() {
		
		System.out.println("Metodo static referenciado.");
	}
	
	public void referenciarMetodoInstancioObjetoArbitrario() {
		
		String[] nombres = {"cadena3", "cadena1", "cadena2"};
		
/*		
   		Arrays.sort(nombres, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareToIgnoreCase(o2);
			}
		});
*/		
		//Comparator es una interfaz funcional.
		//Traducido lo de arriba a Lambda:
		Arrays.sort(nombres, (s1,s2)->s1.compareToIgnoreCase(s2));
		System.out.println("Los nombres son: " + Arrays.toString(nombres));
		
		//Otra forma de llamarlo como referencia a metodo:
		Arrays.sort(nombres, String::compareToIgnoreCase);
		System.out.println("Los nombres son (2): " + Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular() {
		
		System.out.println("Metodo referido a instancia de clase");
	}
	
	public void operar() {
		
		//Una forma de referenciar un metodo estatico es con una expresion lambda:
		IOperacion op = () -> MeRefApp.referenciarMetodoStatic();
		op.saludar(); //Este saludar, que es metodo de la interfaz, en realidad se llama al referenciarMetodoStatic.
		
		//Otra forma de referenciar un metodo estatico es con dos puntos y sin parentesis:
		IOperacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
	}
	
	public void referenciarConstructor() {
	
		
		IPersona iper = new IPersona() {

			@Override
			public Persona crear(int id, String nombre) {
				
				return new Persona(id, nombre);
			}
		};
		Persona per = iper.crear(1, "Juan");
		System.out.println(per.getId() +"-"+per.getNombre());
		
		//Con Lambda:
		IPersona iper2 = (x,y) -> (new Persona(x,y));
		Persona per2 = iper2.crear(2, "Pedro");
		System.out.println(per2.getId() +"-"+per2.getNombre());
		
		//Con referencia a objetos:
		IPersona iper3 = Persona::new;
		Persona per3 = iper3.crear(3, "Lucas");
		System.out.println(per3.getId() +"-"+per3.getNombre());
	}

	public static void main(String[] args) {
		
		MeRefApp app = new MeRefApp();
		
		app.operar();
		
		app.referenciarMetodoInstancioObjetoArbitrario();
		
		//Referenciar a un metodo que no es estatico de un objeto en concreto:
		IOperacion op = app::referenciarMetodoInstanciaObjetoParticular;
		op.saludar(); //Este saludar, que es metodo de la interfaz, en realidad se llama al referenciarMetodoInstanciaObjetoParticular.
		
		app.referenciarConstructor();
	}
}
