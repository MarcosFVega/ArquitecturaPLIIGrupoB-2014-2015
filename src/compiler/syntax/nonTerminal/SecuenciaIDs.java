package compiler.syntax.nonTerminal;
import es.uned.lsi.compiler.semantic.type.*;
import java.util.*;

public class SecuenciaIDs extends NonTerminal{
	private List<String> ids = new ArrayList<String>();
	private TypeIF tipo;
	
	public SecuenciaIDs(List<String> ids){
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
		ids.add(s);
	}
	
	public List<String> getIDs(){
		return ids;
	}
	
	public boolean contiene(String id){
		return false;
	}
	
	public int getSize()
	{
		return ids.size();
	}

}
