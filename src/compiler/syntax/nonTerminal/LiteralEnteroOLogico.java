package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;

public class LiteralEnteroOLogico extends NonTerminal{
	private TypeIF tipo;
	
	public LiteralEnteroOLogico(){
		
	}	
	
	public LiteralEnteroOLogico(TypeIF tipo){
		this.tipo = tipo;
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}	
}
