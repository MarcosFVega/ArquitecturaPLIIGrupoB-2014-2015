package compiler.syntax.nonTerminal;

public class SentenciaAsignacionIzq extends NonTerminal{
	private String id;
	private boolean puntero;
	
	public SentenciaAsignacionIzq(String id, boolean puntero){
		this.id=id;
		this.puntero=puntero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPuntero() {
		return puntero;
	}

	public void setPuntero(boolean puntero) {
		this.puntero = puntero;
	}

}
