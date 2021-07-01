package com.ejemplo.java8.lambda;

public interface PersonaA {
	
	public void caminar();
	
	default public void hablar() {
		
		System.out.println("Dentro del metodo default de la interfaz. Esto valdría para definir una funcionalidad comun a todos los objetos que implementen esta interfaz.");
	}
}
