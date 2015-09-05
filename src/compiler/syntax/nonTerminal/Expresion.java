package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.semantic.type.*;
import es.*;

public class Expresion extends NonTerminal{
	private TypeIF tipo;
	private OperandIF operando;
	private int linea;
	private int columna;
	
	public Expresion(TypeIF tipo, int linea, int columna){
		this.tipo=tipo;
		this.linea=linea;
		this.columna=columna;
	}
	
	public OperandIF getOperando() {
		return operando;
	}

	public void setOperando(OperandIF operando) {
		this.operando = operando;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
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
}
	
	
