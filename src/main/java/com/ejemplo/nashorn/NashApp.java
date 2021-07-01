package com.ejemplo.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {

	private ScriptEngineManager m;
	private ScriptEngine e;
	
	public NashApp() {
		
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		
	}

	public void llamarFunciones() throws Exception{
		
		e.eval("print('Codigo javascript desde Java')");
	}

	public void implementarInterfaz() throws Exception{
		
		
	}

	public static void main(String[] args) throws Exception {
		
		NashApp app = new NashApp();
		
		app.llamarFunciones();
	}

}
