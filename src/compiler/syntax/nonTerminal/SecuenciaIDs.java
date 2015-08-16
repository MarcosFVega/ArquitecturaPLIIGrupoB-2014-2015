package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;
import java.util.*;

public class SecuenciaIDs extends NonTerminal{
	private HashMap ids = new HashMap();
	private TypeIF tipo;
	
	public SecuenciaIDs(HashMap ids){
		this.ids = ids;		
	}
	
	public SecuenciaIDs(String id){
		addField(id);	
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}
	
	public void addField(String s){
		ids.put(s,s);
	}
	
	public HashMap getIDs(){
		return ids;
	}
	
	public boolean contiene(String id){
		return false;
	}

}
