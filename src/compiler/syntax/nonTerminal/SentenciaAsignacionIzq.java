package compiler.syntax.nonTerminal;

public class SentenciaAsignacionIzq extends Sentencia{
	private String id;
	private String campo;
	
	public SentenciaAsignacionIzq(String id){
		this.id=id;
	}
	
	public SentenciaAsignacionIzq(String id, String campo){
		this.id=id;
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

}
