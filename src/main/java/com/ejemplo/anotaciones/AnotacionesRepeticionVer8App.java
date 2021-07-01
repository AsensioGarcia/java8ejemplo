package com.ejemplo.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnotacionesRepeticionVer8App {

	//Me creo una nueva anotacion:
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {

		Lenguaje[] value() default {};
	}

	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje {
		
		String value();
	}

	@Lenguaje("Java")
	@Lenguaje("Phyton")
	public interface LenguajeProgramacion {
		
	}

	public static void main(String[] args) {
		
		//Con API reflection vamos a consultar las anotaciones de la clase:
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tiene " + lenguajeArray.length + " anotaciones en lenguaje.");
		
		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		
		for(Lenguaje elemento: len.value()) {
			
			System.out.println(elemento.value());
		}
	}

}
