package compiler.syntax.nonTerminal;
import compiler.semantic.type.TypeRecord;

import es.uned.lsi.compiler.semantic.type.*;

public class CampoRegistro extends NonTerminal{
	private TypeIF tipo;
	private String nombre;
	
	public CampoRegistro(String nombre,TypeIF tr){
		this.nombre=nombre;
		tipo = tr;		
	}


	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeRecord tipo) {
		this.tipo = tipo;
	}
	
	public TypeRecord getTipoRegistro(){
		return (TypeRecord) tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
