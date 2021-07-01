package com.ejemplo.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnotacionesRepeticionVer7App {

	//Me creo una nueva anotacion:
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {

		Lenguaje[] value() default {};
	}

	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje {
		
		String value();
	}

	//Las anotaciones de 1.7 para atras es:
	@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Phyton")
	})
	public interface LenguajeProgramacion {
		
	}

	public static void main(String[] args) {
		
		//Con API reflection vamos a consultar las anotaciones de la clase:
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tiene " + lenguajeArray.length + " anotaciones en lenguaje.");
	}

}
