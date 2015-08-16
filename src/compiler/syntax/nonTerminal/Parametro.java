package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;

public class Parametro extends NonTerminal{
	private TypeIF tipo;
	private SecuenciaIDs ids;
	
	public Parametro(SecuenciaIDs ids, TypeIF tipo){
		this.tipo=tipo;
		this.ids=ids;	
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}

	public SecuenciaIDs getSecuenciaIDs() {
		return ids;
	}

	public void setSecuenciaIDs(SecuenciaIDs ids) {
		this.ids = ids;
	}

}
