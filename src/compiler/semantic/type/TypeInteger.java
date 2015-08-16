package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

public class TypeInteger extends TypeSimple{
	
	public TypeInteger (ScopeIF scope)
    {
         super(scope);
	     super.setName( "INTEGER");
    }

}
