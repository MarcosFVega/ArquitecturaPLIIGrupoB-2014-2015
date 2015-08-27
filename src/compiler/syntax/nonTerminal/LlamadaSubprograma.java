package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends Sentencia{
	private TypeIF tipo;
	public LlamadaSubprograma(){
		
	}
	public TypeIF getTipo() {
		return tipo;
	}
	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}
}
