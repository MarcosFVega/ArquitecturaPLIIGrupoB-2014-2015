package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import compiler.syntax.nonTerminal.Parametro;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeFunction.
 */

// TODO: Student work
//       Include properties to characterize function declarations

public class TypeFunction
    extends TypeProcedure
{   
	private List<Parametro> parametros = new ArrayList<Parametro>();
	private TypeIF salida;
	
    public TypeFunction (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope
     * @param name The name of the function.
     */
    public TypeFunction (ScopeIF scope, String name, TypeIF tipo)
    {
        super (scope, name);
        salida = tipo;
    }
    
    public TypeIF getSalida() {
		return salida;
	}

	public void setSalida(TypeIF salida) {
		this.salida = salida;
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
	
}
