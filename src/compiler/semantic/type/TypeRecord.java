package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.*;
import java.util.*;

import compiler.syntax.nonTerminal.CampoRegistro;

/**
 * Class for TypeRecord.
 */

// TODO: Student work
//       Include properties to characterize records

public class TypeRecord
    extends TypeBase
{   
    
	private HashMap<String,CampoRegistro> campos = new HashMap<String,CampoRegistro>();
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     */
    public TypeRecord (ScopeIF scope)
    {
        super (scope);
    }
    
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeRecord (ScopeIF scope, String name)
    {   
        super (scope, name);
    }
   
    /**
     * Constructor for TypeRecord.
     * @param record The record to copy.
     */
    public TypeRecord (TypeRecord record)
    {
        super (record.getScope (), record.getName ());
    } 
    
    public void addField(String nombre, CampoRegistro tipo){
    	campos.put(nombre,tipo);
    }
    
    public boolean contieneCampo(String registro){
    	if (campos.containsKey(registro))
    		return true;
    	else
    		return false;
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

	public HashMap getCampos() {
		return campos;
	}

	public void setCampos(HashMap campos) {
		this.campos = campos;
	}
	
	public TypeIF tipoCampo(String campo){
		return campos.get(campo).getTipo();
	}
}
