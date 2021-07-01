package com.ejemplo.java8.lambda;

public class ScopesLambda {
	
	private static double atributo1;
	
	public double probarLocalVariable() {
		
		final double n3 = 3;
		
		Operacion operacion = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				
				return n1 + n2 + n3;
			}
			
		};
		
		return operacion.calcular(2, 3);
	}
	
	public double probarLocalVariableLambda() {
		
		final double n3 = 3;
		
		
		Operacion operacion = (double n1, double n2) -> {
			
			return n1 + n2 + n3;
		};
		
		return operacion.calcular(2, 3);
	}

	
	public double probarAtributosStaticVariables() {
		
		Operacion operacion = (x, y) -> {
			
			atributo1 = x + y;
			return atributo1;
		};
		
		return operacion.calcular(2, 3);
		
	}

    public static void main( String[] args ){
    
    	ScopesLambda app = new ScopesLambda();
    	
       	System.out.println("Probar variable local:");
    	System.out.println(app.probarLocalVariable());
    	
       	System.out.println("Probar variable local lambda:");
    	System.out.println(app.probarLocalVariableLambda());
    	
    	System.out.println("Probar Atributos Static Variables:");
    	System.out.println(app.probarAtributosStaticVariables());
  	
    }
}
