package com.ejemplo.finterface;

public class InterfazFuncionalApp {

	public double operar(double x, double y) {
		
		IFuncional op = (n1, n2) -> n1 + n2;
		
		return op.realizarOperacion(x, y);
	}
	
	public static void main(String[] args) {
		
		InterfazFuncionalApp app = new InterfazFuncionalApp();
		
		double resp = app.operar(2, 3);
		
		System.out.println("Respuesta: "+ resp);
	}

}
