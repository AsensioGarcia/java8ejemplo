package com.ejemplo.java8.lambda;

public class DefaultMethod implements PersonaA, PersonaB{

	@Override
	public void caminar() {

		System.out.println("Dentro de caminar.");
	}

	//Si implemento de 2 interfaces con el mismo default method, hay que especificarlo, si es de uno solo, esta parte sobra:
	@Override
	public void hablar() {
		
		PersonaA.super.hablar();
	}

	public static void main(String[] args) {
		
		DefaultMethod app = new DefaultMethod();
		
		app.caminar();
		app.hablar();
	}
}
