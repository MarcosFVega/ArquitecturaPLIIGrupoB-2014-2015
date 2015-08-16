package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

import java.util.*;

public class DeclaracionParametros extends NonTerminal{
	private List<Parametro> parametros = new ArrayList<Parametro>();
	
	public DeclaracionParametros(){
	
	}
	
	public DeclaracionParametros(List<Parametro> parametros){
		this.parametros = parametros;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
}
