package compiler.syntax.nonTerminal;

import java.util.*;

public class SecuenciaParametros extends NonTerminal{
	private List<Parametro> parametros = new ArrayList<Parametro>();
	
	public SecuenciaParametros(Parametro parametro){
		parametros.add(parametro);		
	}
	
	public SecuenciaParametros(List<Parametro> parametros){
		this.parametros=parametros;
	}
	
	public List<Parametro> getParametros(){
		return parametros;
	}
	
	public boolean contiene(Parametro p){
		if (parametros.contains(p)) return true;
		else return false;
	}
	
	public void addParametro(Parametro p){
		parametros.add(p);
	}

}
