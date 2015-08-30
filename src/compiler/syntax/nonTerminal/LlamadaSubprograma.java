package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends Sentencia{
	private TypeIF tipo;
	private String nombre;

	public LlamadaSubprograma(String nombre){
		this.nombre=nombre;
	}
	
	public LlamadaSubprograma(){
		this.nombre=nombre;
	}
	public TypeIF getTipo() {
		return tipo;
	}
	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
