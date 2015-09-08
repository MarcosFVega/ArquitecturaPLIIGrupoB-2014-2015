package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.intermediate.OperandIF;

public class LiteralLogico extends NonTerminal{
	private OperandIF operando;
	
	public LiteralLogico(){
	}

	public OperandIF getOperando() {
		return operando;
	}

	public void setOperando(OperandIF operando) {
		this.operando = operando;
	}
}
