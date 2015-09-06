package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.intermediate.OperandIF;

public class ParametroWrite extends Sentencia{
	private OperandIF operando;
	
	public ParametroWrite(){
	}
	
	public ParametroWrite(OperandIF operando){
		this.operando=operando;
	}

	public OperandIF getOperando() {
		return operando;
	}

	public void setOperando(OperandIF operando) {
		this.operando = operando;
	}
	
	
}
