package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

public class TypeBoolean extends TypeSimple{
	
	public TypeBoolean (ScopeIF scope)
    {
         super(scope);
	     super.setName("BOOLEAN");
    }

}
