package compiler.code;

import java.util.Arrays;
import java.util.List;

import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.code.MemoryDescriptorIF;
import es.uned.lsi.compiler.code.RegisterDescriptorIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

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
    	
    	switch(quadruple.getOperation()){
    		case "INICIAR": 
    			traduccion = "INICIAR:\n"; ;
    			traduccion = traduccion + "MOVE #65535 .SP\n";   
    			traduccion = traduccion + "MOVE .SP .IY";    				
    			break;
    		case "HALT": 
    			traduccion = "HALT"; break;
    		case "SUB": 
    			traduccion = "SUB"; break;    
    		case "ASN": 
    			traduccion = "ASN"; break; 
    		case "BRF": 
    			traduccion = "BRF"; break; 
    		case "BR": 
    			traduccion = "BR"; break; 
    		case "CALL": 
    			traduccion = "CALL"; break;
    		case "INL": 
    			traduccion = "INL"; break; 
    		case "INC": 
    			traduccion = "INC"; break; 
    		case "REG_POING": 
    			traduccion = "REG_POING"; break;
    		case "WRITE": 
    			traduccion = "WRITE"; break;
    		case "WRITELN": 
    			traduccion = "WRITELN"; break;
    		case "MVA": 
    			traduccion = "MVA"; break;
    		case "MVP": 
    			traduccion = "MVP"; break;
    		case "LS": 
    			traduccion = "LS"; break;
    		case "REG": 
    			traduccion = "REG"; break;
    		default:
    			break;
    	}    	
        return traduccion; 
    }
}
