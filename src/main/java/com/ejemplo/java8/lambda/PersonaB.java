package com.ejemplo.java8.lambda;

public interface PersonaB {
	
	public void caminar();
	
	default public void hablar() {
		
		System.out.println("Dentro del metodo default de la interfaz 2.");
	}
}
