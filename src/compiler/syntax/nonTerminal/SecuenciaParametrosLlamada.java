package compiler.syntax.nonTerminal;

import java.util.*;

public class SecuenciaParametrosLlamada extends NonTerminal{
	private List<Expresion> parametros = new ArrayList<Expresion>();
	
	public SecuenciaParametrosLlamada(Expresion parametro){
		parametros.add(parametro);		
	}
	
	public SecuenciaParametrosLlamada(List<Expresion> secuencia, Expresion parametro){
		parametros.addAll(secuencia);
		parametros.add(parametro);		
	}
	
	public SecuenciaParametrosLlamada(List<Expresion> parametros){
		this.parametros=parametros;
	}
	
	public List<Expresion> getParametros(){
		return parametros;
	}
	
	public boolean contiene(Expresion p){
		if (parametros.contains(p)) return true;
		else return false;
	}
	
	public void addParametro(Expresion p){
		parametros.add(p);
	}

}
