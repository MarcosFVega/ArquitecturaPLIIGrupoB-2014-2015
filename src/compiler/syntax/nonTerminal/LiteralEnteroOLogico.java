package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;

public class LiteralEnteroOLogico extends NonTerminal{
	private TypeIF tipo;
	private int valor;
	
	public LiteralEnteroOLogico(){
		
	}	
	
	public LiteralEnteroOLogico(TypeIF tipo, int valor){
		this.tipo = tipo;
		this.valor = valor;
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
