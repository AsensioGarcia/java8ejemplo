package com.ejemplo.optional;

import java.util.Optional;

public class OptionalApp {

	public void probar(String valor) {
		
		try {
			
			Optional op = Optional.empty();
			op.get();
		}catch (Exception e) {

			System.out.println("No hay elemento.");
		}
	}
	
	public void orElse(String valor) {
		
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElse("ValorPorDefectoSiNulo");
		
		System.out.println(x);
	}
	
	public void orElseThrow(String valor) {
		
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new);
	}
	
	public void isPresent(String valor) {
		
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
	}

	
	public static void main(String[] args) {
		
		OptionalApp app = new OptionalApp();
		
		app.probar(null);
		
		app.orElse("OrElse");
		app.orElse(null);
		
		app.isPresent("IsPresent");
		app.isPresent(null);
		
		app.orElseThrow("OrElseThrow");
		app.orElseThrow(null);
		
	}

}
