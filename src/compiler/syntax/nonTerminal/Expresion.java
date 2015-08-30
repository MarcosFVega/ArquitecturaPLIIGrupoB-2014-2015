package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;
import es.*;

public class Expresion extends NonTerminal{
	private TypeIF tipo;
	private boolean b_valor;
	private int linea;
	private int columna;
	
	public Expresion(TypeIF tipo, int linea, int columna){
		this.tipo=tipo;
		this.linea=linea;
		this.columna=columna;
	}

	public Expresion(TypeIF tipo){		
		this.tipo=tipo;
	}	
	
	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}

	public boolean isB_valor() {
		return b_valor;
	}

	public void setB_valor(boolean b_valor) {
		this.b_valor = b_valor;
	}
	
}
	
	
