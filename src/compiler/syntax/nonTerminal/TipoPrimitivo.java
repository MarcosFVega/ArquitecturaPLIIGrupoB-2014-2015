package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;

public class TipoPrimitivo extends NonTerminal{
	private TypeIF tipo;
	private int valor;
	
	public TipoPrimitivo(){
	}
	
	public TipoPrimitivo(TypeIF tipo){
		this.tipo=tipo;					
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}
	
}
