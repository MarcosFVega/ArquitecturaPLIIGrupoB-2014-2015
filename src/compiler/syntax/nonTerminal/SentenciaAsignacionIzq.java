package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class SentenciaAsignacionIzq extends Sentencia{
	private String id;
	private String campo;
	private OperandIF operando;
	private TypeIF tipo;
	
	public SentenciaAsignacionIzq(String id){
		this.id=id;
	}
	
	public SentenciaAsignacionIzq(TypeIF tipo,String id){
		this.tipo=tipo;
		this.id=id;
	}

	public SentenciaAsignacionIzq(TypeIF tipo){
		this.tipo=tipo;
	}
	
	public SentenciaAsignacionIzq(String id, String campo){
		this.id=id;
		this.campo=campo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public OperandIF getOperando() {
		return operando;
	}

	public void setOperando(OperandIF operando) {
		this.operando = operando;
	}

	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}
}
