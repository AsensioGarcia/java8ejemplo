package com.ejemplo.finterface;

//Una interfaz funcional solo puede tener un metodo sin implementar, (abstracto). Se marca como tal por 
//seguir los estandares:
@FunctionalInterface
public interface IFuncional {
	
	double realizarOperacion(double x, double y);
	//void operacion2();
}
