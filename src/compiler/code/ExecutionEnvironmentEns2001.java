package compiler.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import compiler.intermediate.Procedure;
import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;
import compiler.semantic.symbol.SymbolConstant;
import compiler.semantic.type.TypeSimple;
import compiler.semantic.type.TypeProcedure;
import compiler.semantic.type.TypeRecord;
import compiler.syntax.nonTerminal.CampoRegistro;
import compiler.syntax.nonTerminal.Parametro;
import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.code.MemoryDescriptorIF;
import es.uned.lsi.compiler.code.RegisterDescriptorIF;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

/**
 * Class for the ENS2001 Execution environment.
 */

public class ExecutionEnvironmentEns2001 
    implements ExecutionEnvironmentIF
{    
    private final static int      MAX_ADDRESS = 65535; 
    private final static String[] REGISTERS   = {
       ".PC", ".SP", ".SR", ".IX", ".IY", ".A", 
       ".R0", ".R1", ".R2", ".R3", ".R4", 
       ".R5", ".R6", ".R7", ".R8", ".R9"
    };
    
    private RegisterDescriptorIF registerDescriptor;
    private MemoryDescriptorIF   memoryDescriptor;
    private static ArrayList<String> texts = new ArrayList<String>();
    HashMap<String,Integer> listaScopes = new HashMap<String,Integer>();
    ArrayList<OperandIF> listArg = new ArrayList<OperandIF>();
    
    /**
     * Constructor for ENS2001Environment.
     */
    public ExecutionEnvironmentEns2001 ()
    {       
        super ();
    }
    
    /**
     * Returns the size of the type within the architecture.
     * @return the size of the type within the architecture.
     */
    @Override
    public final int getTypeSize (TypeSimple type)
    {      
        return 1;  
    }
    
    /**
     * Returns the registers.
     * @return the registers.
     */
    @Override
    public final List<String> getRegisters ()
    {
        return Arrays.asList (REGISTERS);
    }
    
    /**
     * Returns the memory size.
     * @return the memory size.
     */
    @Override
    public final int getMemorySize ()
    {
        return MAX_ADDRESS;
    }
           
    /**
     * Returns the registerDescriptor.
     * @return Returns the registerDescriptor.
     */
    @Override
    public final RegisterDescriptorIF getRegisterDescriptor ()
    {
        return registerDescriptor;
    }

    /**
     * Returns the memoryDescriptor.
     * @return Returns the memoryDescriptor.
     */
    @Override
    public final MemoryDescriptorIF getMemoryDescriptor ()
    {
        return memoryDescriptor;
    }

    /**
     * Translate a quadruple into a set of final code instructions. 
     * @param cuadruple The quadruple to be translated.
     * @return a quadruple into a set of final code instructions. 
     */
    @Override
    public final String translate (QuadrupleIF quadruple)
    {      
    	String traduccion="";
    	Variable var;
    	Value val;
    	Temporal t;
    	OperandIF op1 = quadruple.getFirstOperand();
    	OperandIF op2 = quadruple.getSecondOperand();
    	OperandIF res = quadruple.getResult();
    	String operador1 = "";
    	String operador2 = "";
    	String resultado = "";    	 
		int offset;

    	
    	switch(quadruple.getOperation()){
    		case "INICIAR": 
    			listaScopes = (HashMap)((Value)res).getValue();    		
    			traduccion = "ORG 20000\nINICIAR:\n"; 
    			traduccion = traduccion + "MOVE #65535, .SP\n";   
    			traduccion = traduccion + "MOVE .SP, .IX";    				
    			break;
    		case "HALT": 
    			traduccion = "HALT\n"; break;    			
    		case "SUB":  
    			
    			//OPERADOR 1
				if (op1 instanceof Value){
					Value v = (Value)op1;
					operador1 = "#" + v.getValue();
				}else if (op1 instanceof Variable){
					
					var = (Variable)op1;
					SymbolIF sv = var.getScope().getSymbolTable().getSymbol(var.getName());
					if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
					else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
					else offset = ((SymbolVariable) sv).getAddress();
					   				
					
					if (sv.getScope().getLevel()==0){
						traduccion = traduccion + "MOVE /" + offset + ", .R1\n";
					}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R1\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R1\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));	    					
	    				}	  				 
					} 
					operador1 = ".R1";					
    			}else{
    				t = (Temporal)op1;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R1\n";
	    			operador1 = ".R1";
    			}
    			
    			//OPERADOR 2
    			if (op2 instanceof Value){    				
    				val = (Value)op2;    	
    				operador2 = "#" + val.getValue();
    			}else if (op2 instanceof Variable){
    				
    				var = (Variable)op2;
    				SymbolIF sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					traduccion = traduccion + "MOVE /" + offset + ", .R3\n";
    				}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R3\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R3\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  				 
    				} 
    				operador2 = ".R3";
    			}else{
    				t = (Temporal)op2;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R3\n";
	    			operador2 = ".R3";
    			}
    			//RESULTADO  
				t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";    			
    			
    			traduccion = traduccion + "SUB " + operador1 + ", " + operador2 + "\n"; 
    			traduccion = traduccion + "MOVE .A, " + resultado;
    			break;    
    		case "ASN": 
    			//VARIABLE DONDE SE ASIGNA
    			if (res instanceof Variable){
    				var = (Variable)res;
    				SymbolIF sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					resultado = "/" + offset;
    				}else{
    					if (var.getScope().getName().equals(sv.getScope().getName()))
    						resultado = "#-" + offset + "[.IX]";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R1";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "#-" + offset + "[.R1]";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R1], .R1";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  
    				}
				}else{
					t = (Temporal)res;
	    			resultado = "#-" + t.getAddress() + "[.IX]";
				}
    			
    			//VALOR A ASIGNAR
    			if (op1 instanceof Value){    				
    				val = (Value)op1;    	
    				operador2 = "#" + val.getValue();
    			}else if (op1 instanceof Variable){
    				
    				var = (Variable)op1;
    				SymbolIF sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					operador2 = "/" + offset;
    				}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					operador2 ="#-" + offset + "[.IX]";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						operador2 = "#-" + offset + "[.R2]";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  				 
    				} 
    			}else{
    				t = (Temporal)op1;
	    			operador2 = "#-" + t.getAddress() + "[.IX]";
    			}
    			
    			traduccion = "MOVE " + operador2 + ", " + resultado; 
    			break; 
    		case "STP": 
    			//VARIABLE DONDE SE ASIGNA
    			
				var = (Variable)res;
				SymbolIF sv = var.getScope().getSymbolTable().getSymbol(var.getName());
				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
				else offset = ((SymbolVariable) sv).getAddress();    				   				
				
				if (sv.getScope().getLevel()==0){
					traduccion = "MOVE /" + offset + ", .R1\n";
				}else{
					if (var.getScope().getName().equals(sv.getScope().getName()))
						traduccion = "MOVE #-" + offset + ", .R1\n";
    				else{	
    					ScopeIF parent = sv.getScope().getParentScope();
    					traduccion = traduccion + "MOVE #2[.IX], .R1";
    					do{	 
	    					if (parent.getSymbolTable().containsSymbol(sv))
	    						traduccion = "MOVE #-" + offset + "[.R2], .R1";
	    					else{
	    						parent = parent.getParentScope();
	    						traduccion = traduccion + "MOVE #2[.R2], .R2\n";
	    					}
    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
    				}	  
				}
				
    			
    			//VALOR A ASIGNAR
    			if (op1 instanceof Value){    				
    				val = (Value)op1;    	
    				operador2 = "#" + val.getValue();
    			}else if (op1 instanceof Variable){
    				
    				var = (Variable)op1;
    				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					operador2 = "/" + offset;
    				}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					operador2 ="#-" + offset + "[.IX]";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						operador2 = "#-" + offset + "[.R2]";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  				 
    				} 
    			}else{
    				t = (Temporal)op1;
	    			operador2 = "#-" + t.getAddress() + "[.IX]";
    			}
    			
    			traduccion = traduccion + "MOVE " + operador2 + ", [.R1]"; 
    			break; 
    		case "BN": 
    			traduccion = "BN /" + res.toString();
    			break; 
    		case "BR":      	        
    			traduccion = "BR /" + res.toString();
    	        break;
    		case "BZ":      	        
    			traduccion = "BZ /" + res.toString();
    	        break;
    		case "ARG":    			
    			listArg.add(res);
    			break;
    			
    		case "CALL":    			
    			Procedure proc = (Procedure)res;
    			String scopeLlamada = ((String)((Value)op1).getValue());  
    			int scope_offset = listaScopes.get(scopeLlamada);
    			
    			traduccion = "MOVE .IX, #-" + (scope_offset+4) + "[.IX]\n";    			
    			traduccion = traduccion + "SUB .IX, #" + (scope_offset+4) + "\n";
    			traduccion = traduccion + "MOVE .A, .IX\n";
    			traduccion = traduccion + "MOVE .PC, #-" + (scope_offset+3) + "[.IX]\n";
    			traduccion = traduccion + "BR /" + proc.getCodeLabel();
    			listArg.clear();
    			break;
    		case "FINS":
    			traduccion = traduccion + "MOVE .IX, .SP\n";
    			traduccion = traduccion + "MOVE [.IX], .IX\n";
    			traduccion = traduccion + "MOVE #1[.IX], .R1\n";
    			traduccion = traduccion + "BR [.R1]";
    			break;
    		case "INL": 
    			traduccion = res.toString() + ":";
    			break; 
    		case "INC":	
    			var = (Variable)res;
				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
				else offset = ((SymbolVariable) sv).getAddress();    				   				
				
				if (sv.getScope().getLevel()==0){
					traduccion = traduccion + "INC /" + offset;
				}else{
					if (var.getScope().getName().equals(sv.getScope().getName()))
    					traduccion = traduccion + "INC #-" + offset + "[.IX]";
    				else{
    					ScopeIF parent = sv.getScope().getParentScope();
    					traduccion = traduccion + "MOVE #2[.IX], .R1";
    					do{	 
	    					if (parent.getSymbolTable().containsSymbol(sv))
	    						traduccion = traduccion + "INC #-" + offset + "[.R1]";
	    					else{
	    						parent = parent.getParentScope();
	    						traduccion = traduccion + "MOVE #2[.R1], .R1";
	    					}
    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
    				}					
				}
    			break; 
    		case "REG_POINT": 
    			traduccion = "REG_POINT"; break;
    		case "WRITE":
    			if (res instanceof Value){  
    				texts.add(res.toString());
    				int pos = texts.size()-1;
    				traduccion = "WRSTR /texto" + pos;
    			}else if (res instanceof Variable){
    				var = (Variable)res;
    				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					traduccion = traduccion + "WRINT /" + offset;
    				}else{
    					if (var.getScope().getName().equals(sv.getScope().getName()))
        					traduccion = traduccion + "WRINT #-" + offset + "[.IX]";
        				else{
        					ScopeIF parent = sv.getScope().getParentScope();
        					traduccion = traduccion + "MOVE #2[.IX] .R1";
        					do{	 
    	    					if (parent.getSymbolTable().containsSymbol(sv))
    	    						traduccion = traduccion + "WRINT #-" + offset + "[.R1]";
    	    					else{
    	    						parent = parent.getParentScope();
    	    						traduccion = traduccion + "MOVE #2[.R1] .R1";
    	    					}
        					}while(!(parent.getSymbolTable().containsSymbol(sv))); 
        				}
    				}
    			}else{
    				t = (Temporal)res;
	    			traduccion = "WRINT #-" + t.getAddress() + "[.IX]";
				}
    			break;
    		case "WRITELN":     			
    			traduccion = "WRSTR /SaltoLinea"; break;
    		case "MVA": 
    			   			
				t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";
    			
				var = (Variable)op1;
				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
				else offset = ((SymbolVariable) sv).getAddress();   
								
				
				if (sv.getScope().getLevel()==0){
					operador2 = "#" + Integer.toString(offset);
				}else{
    				if (var.getScope().getName().equals(sv.getScope().getName())){
    					traduccion = traduccion + "SUB .IX, " + offset + "\n";
    					operador2 = ".A";
					}else{	
    					ScopeIF parent = sv.getScope().getParentScope();
    					traduccion = traduccion + "MOVE #2[.IX], .R2\n";
    					do{	 
	    					if (parent.getSymbolTable().containsSymbol(sv)){
	    						traduccion = traduccion + "SUB .R2, " + offset;
	    						operador2 = ".A";
	    					}else{
	    						parent = parent.getParentScope();
	    						traduccion = traduccion + "MOVE #2[.R2], .R2\n";
	    					}
    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
    				}	  				 
				} 
				
    			traduccion = "MOVE " + operador2 + ", " + resultado; 
    			break;
    			
    		case "MVP": 
    			t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";
			    				
				var = (Variable)op1;
				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
				else offset = ((SymbolVariable) sv).getAddress();    				   				
				
				if (sv.getScope().getLevel()==0){
					traduccion = "MOVE /" + Integer.toString(offset) + ", .R1\n";
					operador2 = "[.R1]";
				}else{
    				if (var.getScope().getName().equals(sv.getScope().getName())){
    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R1\n";
    					operador2 = "[R1]";
					}else{	
    					ScopeIF parent = sv.getScope().getParentScope();
    					traduccion = traduccion + "MOVE #2[.IX], .R2";
    					do{	 
	    					if (parent.getSymbolTable().containsSymbol(sv)){
	    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R1\n";
	        					operador2 = "[R1]";
	    					}else{
	    						parent = parent.getParentScope();
	    						traduccion = traduccion + "MOVE #2[.R2], .R2\n";
	    					}
    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
    				}	  				 
				} 
				
    			traduccion = traduccion + "MOVE " + operador2 + ", " + resultado; 
    			break; 
    			
    		case "MVP_REG": 
    			t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";
			    				
				var = (Variable)op1;
				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
				else offset = ((SymbolVariable) sv).getAddress();    				   				
				
				if (sv.getScope().getLevel()==0){
					var = (Variable)op2;
					TypeRecord tr = (TypeRecord)sv.getType();
    				HashMap<String,CampoRegistro> campos = tr.getCampos();
    				
    				Iterator it = campos.entrySet().iterator();
    				int pos = 0;
    				while (it.hasNext()) {
    					pos++;
	    				Map.Entry e = (Map.Entry)it.next();
	    				if (var.getName().equals(e.getKey().toString())) break;
    				}
    				offset = ((SymbolVariable) sv).getAddress()+(pos-1); 
    				traduccion = "MOVE #" + offset + ", .R1\n";
					operador2 = "[.R1]";
				}
				
    			traduccion = traduccion + "MOVE " + operador2 + ", " + resultado; 
    			break; 
    			
    		case "EQ": 
       			
    			//OPERADOR 1
				if (op1 instanceof Value){
					val = (Value)op1;
					operador1 = "#" + val.getValue();
				}else if (op1 instanceof Variable){
					
					var = (Variable)op1;
					sv = var.getScope().getSymbolTable().getSymbol(var.getName());
					if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
					else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
					else offset = ((SymbolVariable) sv).getAddress();
					   				
					
					if (sv.getScope().getLevel()==0){
						traduccion = traduccion + "MOVE /" + offset + ", .R1\n";
					}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R1\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R1\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));	    					
	    				}	  				 
					} 
					operador1 = ".R1";					
    			}else{
    				t = (Temporal)op1;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R1\n";
	    			operador1 = ".R1";
    			}
    			
    			//OPERADOR 2
    			if (op2 instanceof Value){    				
    				val = (Value)op2;    	
    				operador2 = "#" + val.getValue();
    			}else if (op2 instanceof Variable){
    				
    				var = (Variable)op2;
    				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					traduccion = traduccion + "MOVE /" + offset + ", .R3\n";
    				}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R3\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R3\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  				 
    				} 
    				operador2 = ".R3";
    			}else{
    				t = (Temporal)op2;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R3\n";
	    			operador2 = ".R3";
    			}
    			//RESULTADO  
				t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";    			
    			
    			traduccion = traduccion + "CMP " + operador1 + ", " + operador2;
    			break;    
    		case "REG": 
    			Variable v1 = (Variable)op1;
    			Variable v2 = (Variable)op2;
    			t = (Temporal)res;
    			sv = v1.getScope().getSymbolTable().getSymbol(v1.getName());
    			
    			if(sv.getScope().getLevel()==0){
    				TypeRecord tr = (TypeRecord)sv.getType();
    				HashMap<String,CampoRegistro> campos = tr.getCampos();
    				
    				Iterator it = campos.entrySet().iterator();
    				int pos = 0;
    				while (it.hasNext()) {
    					pos++;
	    				Map.Entry e = (Map.Entry)it.next();
	    				if (v2.getName().equals(e.getKey().toString())) break;
    				}
    				offset = ((SymbolVariable) sv).getAddress()+(pos-1); 
    				traduccion = "MOVE #" + offset + ", .R1\n";
    				traduccion = traduccion + "MOVE /" + offset + ", #-" + t.getAddress() + "[.IX]";
    			}
    			
    			break;
    		case "REG_PNT": 
    			v1 = (Variable)op1;
    			v2 = (Variable)op2;
    			t = (Temporal)res;
    			sv = v1.getScope().getSymbolTable().getSymbol(v1.getName());
    			
    			if(sv.getScope().getLevel()==0){
    				TypeRecord tr = (TypeRecord)sv.getType();
    				HashMap<String,CampoRegistro> campos = tr.getCampos();
    				
    				Iterator it = campos.entrySet().iterator();
    				int pos = 0;
    				while (it.hasNext()) {
    					pos++;
	    				Map.Entry e = (Map.Entry)it.next();
	    				if (v2.getName().equals(e.getKey().toString())) break;
    				}
    				offset = ((SymbolVariable) sv).getAddress()+(pos-1); 
    				traduccion = "MOVE #" + offset + ", .R1\n";
    				traduccion = traduccion + "MOVE /" + offset + ", #-" + t.getAddress() + "[.IX]";
    			}
    			
    			break;
    			
    		case "AREG": 
    			{
    				if (op1 instanceof Value){    				
        				val = (Value)op1;    	
        				operador2 = "#" + val.getValue();
        			}else if (op1 instanceof Variable){
        				
        				var = (Variable)op1;
        				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
        				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
        				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
        				else offset = ((SymbolVariable) sv).getAddress();    				   				
        				
        				if (sv.getScope().getLevel()==0){
        					operador2 = "/" + offset;
        				}else{
    	    				if (var.getScope().getName().equals(sv.getScope().getName()))
    	    					operador2 ="#-" + offset + "[.IX]";
    	    				else{	
    	    					ScopeIF parent = sv.getScope().getParentScope();
    	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
    	    					do{	 
    		    					if (parent.getSymbolTable().containsSymbol(sv))
    		    						operador2 = "#-" + offset + "[.R2]";
    		    					else{
    		    						parent = parent.getParentScope();
    		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
    		    					}
    	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
    	    				}	  				 
        				} 
        			}else{
        				t = (Temporal)op1;
    	    			operador2 = "#-" + t.getAddress() + "[.IX]";
        			}
        			
    				traduccion = "MOVE " + operador2 + ", [.R1]";
    			}
    			
    			break;
    		case "OR": 
    			//OPERADOR 1
				if (op1 instanceof Value){
					val = (Value)op1;
					operador1 = "#" + val.getValue();
				}else if (op1 instanceof Variable){
					
					var = (Variable)op1;
					sv = var.getScope().getSymbolTable().getSymbol(var.getName());
					if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
					else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
					else offset = ((SymbolVariable) sv).getAddress();
					   				
					
					if (sv.getScope().getLevel()==0){
						traduccion = traduccion + "MOVE /" + offset + ", .R1\n";
					}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R1\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R1\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));	    					
	    				}	  				 
					} 
					operador1 = ".R1";					
    			}else{
    				t = (Temporal)op1;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R1\n";
	    			operador1 = ".R1";
    			}
    			
    			//OPERADOR 2
    			if (op2 instanceof Value){    				
    				val = (Value)op2;    	
    				operador2 = "#" + val.getValue();
    			}else if (op2 instanceof Variable){
    				
    				var = (Variable)op2;
    				sv = var.getScope().getSymbolTable().getSymbol(var.getName());
    				if (sv instanceof SymbolParameter) offset = ((SymbolParameter) sv).getAddress();
    				else if (sv instanceof SymbolConstant) offset = ((SymbolConstant) sv).getAddress();
    				else offset = ((SymbolVariable) sv).getAddress();    				   				
    				
    				if (sv.getScope().getLevel()==0){
    					traduccion = traduccion + "MOVE /" + offset + ", .R3\n";
    				}else{
	    				if (var.getScope().getName().equals(sv.getScope().getName()))
	    					traduccion = traduccion + "MOVE #-" + offset + "[.IX], .R3\n";
	    				else{	
	    					ScopeIF parent = sv.getScope().getParentScope();
	    					traduccion = traduccion + "MOVE #2[.IX], .R2";
	    					do{	 
		    					if (parent.getSymbolTable().containsSymbol(sv))
		    						traduccion = traduccion + "MOVE #-" + offset + "[.R2], .R3\n";
		    					else{
		    						parent = parent.getParentScope();
		    						traduccion = traduccion + "MOVE #2[.R2], .R2";
		    					}
	    					}while(!(parent.getSymbolTable().containsSymbol(sv)));
	    				}	  				 
    				} 
    				operador2 = ".R3";
    			}else{
    				t = (Temporal)op2;
	    			traduccion = traduccion + "MOVE #-" + t.getAddress() + "[.IX], .R3\n";
	    			operador2 = ".R3";
    			}
    			//RESULTADO  
				t = (Temporal)res;
    			resultado = "#-" + t.getAddress() + "[.IX]";    			
    			
    			traduccion = traduccion + "OR " + operador1 + ", " + operador2;
    			break;    
    		case "TEXT":
    			traduccion = "texto" + texts.indexOf(res.toString()) + ": DATA \"" + res.toString() + "\""; 
    			break;
    		case "SALTO":     			
    			traduccion = "SaltoLinea" + ": DATA \"\\n\"";
    			break;
    		default:
    			break;
    	}    	
        return traduccion; 
    }
}
