package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.Parametro;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure declarations

public class TypeProcedure
    extends TypeBase
{   
	private List<Parametro> parametros = new ArrayList<Parametro>();
	
    public TypeProcedure (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeProcedure.
     * @param scope The declaration scope
     * @param name The name of the procedure.
     */
    public TypeProcedure (ScopeIF scope, String name)
    {
        super (scope, name);
    }
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return 1;
    }
    
    public List<Parametro> getParametros() {
		return parametros;
	}

	public void addParametro(Parametro param){
		parametros.add(param);
	}
	
	public boolean compararParametros(List<Expresion> parametrosLlamada){
		int num = 0;
		for (int i = 0; i < parametros.size(); i++) { 
			Parametro param = parametros.get(i);
			for (int j=0;j<param.getSize();j++){
				if (param.getTipo().getName().equals(parametrosLlamada.get(num))){
					return false;
				}				
			}			
		}		
		return true;
	}
}
