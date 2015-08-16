package compiler.syntax.nonTerminal;
import compiler.semantic.type.TypeRecord;
import es.uned.lsi.compiler.semantic.type.*;
import java.util.*;

public class SecuenciaCamposRegistro extends NonTerminal {
	private HashMap<String,CampoRegistro> registros = new HashMap<String,CampoRegistro>();
	
	public SecuenciaCamposRegistro(CampoRegistro campo){
		registros.put(campo.getNombre(), campo);
	}
	
	public SecuenciaCamposRegistro(HashMap<String,CampoRegistro> registros){
		this.registros = registros;
	}

	public void addRegistro(String key, CampoRegistro Registro){
		registros.put(key, Registro);
		
	}
	public boolean contieneCampo (String registro){
		if (registros.containsKey(registro)) return true;
		else return false;	
	}

	public HashMap<String, CampoRegistro> getRegistros() {
		return registros;
	}

	public void setRegistros(HashMap<String, CampoRegistro> registros) {
		this.registros = registros;
	}
	
	
	

}
