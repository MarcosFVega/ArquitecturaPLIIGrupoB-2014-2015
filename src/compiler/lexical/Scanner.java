/* The following code was generated by JFlex 1.4.1 on 12/09/15 1:14 */

package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

// incluir aqui, si es necesario otras importaciones


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 12/09/15 1:14 from the specification file
 * <tt>Z:/Dropbox/Ingenieria Informatica/CURSO 3/Procesadores del lenguaje II/Practica/ArquitecturaPLIIGrupoB-2014-2015/doc/specs/scanner.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner, ScannerIF {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int CADENA_CARACTERES = 3;
  public static final int COMENTARIO_UNA_LINEA = 2;
  public static final int COMENTARIO_ENTRE_LLAVES = 1;
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\6\1\5\2\0\1\4\22\0\1\6\1\0\1\11\5\0"+
    "\1\37\1\40\2\0\1\42\1\46\1\50\1\10\1\3\11\2\1\44"+
    "\1\43\1\0\1\45\1\47\1\0\1\52\1\21\1\12\1\22\1\25"+
    "\1\13\1\26\1\14\1\33\1\15\2\1\1\20\1\32\1\16\1\17"+
    "\1\31\1\1\1\27\1\23\1\24\1\30\1\35\1\36\1\1\1\34"+
    "\1\1\3\0\1\51\2\0\1\21\1\12\1\22\1\25\1\13\1\26"+
    "\1\14\1\33\1\15\2\1\1\20\1\32\1\16\1\17\1\31\1\1"+
    "\1\27\1\23\1\24\1\30\1\35\1\36\1\1\1\34\1\1\1\7"+
    "\1\0\1\41\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\2\3\2\4\1\5\1\1\1\6"+
    "\14\2\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\2\25"+
    "\1\26\1\27\1\30\1\31\5\2\1\32\1\33\1\2"+
    "\1\34\3\2\1\35\7\2\1\36\2\2\1\37\6\2"+
    "\1\40\4\2\1\41\3\2\1\42\2\2\1\43\1\44"+
    "\1\45\6\2\1\46\2\2\1\47\1\50\4\2\1\51"+
    "\3\2\1\52\3\2\1\53\1\54\1\2\1\55\1\2"+
    "\1\56\1\57\1\2\1\60";

  private static int [] zzUnpackAction() {
    int [] result = new int[122];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\254\0\327\0\u0102\0\254"+
    "\0\u012d\0\254\0\254\0\u0158\0\254\0\u0183\0\u01ae\0\u01d9"+
    "\0\u0204\0\u022f\0\u025a\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331"+
    "\0\u035c\0\254\0\254\0\254\0\254\0\254\0\u0387\0\254"+
    "\0\254\0\254\0\254\0\254\0\254\0\254\0\254\0\254"+
    "\0\u03b2\0\254\0\254\0\254\0\254\0\u03dd\0\u0408\0\u0433"+
    "\0\u045e\0\u0489\0\327\0\327\0\u04b4\0\327\0\u04df\0\u050a"+
    "\0\u0535\0\327\0\u0560\0\u058b\0\u05b6\0\u05e1\0\u060c\0\u0637"+
    "\0\u0662\0\254\0\u068d\0\u06b8\0\327\0\u06e3\0\u070e\0\u0739"+
    "\0\u0764\0\u078f\0\u07ba\0\327\0\u07e5\0\u0810\0\u083b\0\u0866"+
    "\0\327\0\u0891\0\u08bc\0\u08e7\0\327\0\u0912\0\u093d\0\327"+
    "\0\327\0\327\0\u0968\0\u0993\0\u09be\0\u09e9\0\u0a14\0\u0a3f"+
    "\0\327\0\u0a6a\0\u0a95\0\327\0\327\0\u0ac0\0\u0aeb\0\u0b16"+
    "\0\u0b41\0\u0b6c\0\u0b97\0\u0bc2\0\u0bed\0\327\0\u0c18\0\u0c43"+
    "\0\u0c6e\0\327\0\327\0\u0c99\0\327\0\u0cc4\0\327\0\327"+
    "\0\u0cef\0\327";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[122];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\10\1\11\2\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\6\1\20\1\6\1\21\2\6"+
    "\1\22\1\6\1\23\1\24\1\25\1\26\1\6\1\27"+
    "\3\6\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\7\46"+
    "\1\47\31\46\1\50\15\46\1\51\1\50\1\46\1\52"+
    "\31\46\1\52\11\46\11\53\1\54\41\53\54\0\3\6"+
    "\6\0\25\6\16\0\2\7\54\0\1\12\55\0\1\55"+
    "\43\0\3\6\6\0\1\6\1\56\3\6\1\57\17\6"+
    "\15\0\3\6\6\0\4\6\1\60\1\6\1\61\16\6"+
    "\15\0\3\6\6\0\4\6\1\62\7\6\1\63\10\6"+
    "\15\0\3\6\6\0\15\6\1\64\7\6\15\0\3\6"+
    "\6\0\5\6\1\65\17\6\15\0\3\6\6\0\5\6"+
    "\1\66\7\6\1\67\3\6\1\70\1\71\2\6\15\0"+
    "\3\6\6\0\5\6\1\72\17\6\15\0\3\6\6\0"+
    "\5\6\1\73\1\6\1\74\6\6\1\75\6\6\15\0"+
    "\3\6\6\0\1\6\1\76\23\6\15\0\3\6\6\0"+
    "\15\6\1\77\7\6\15\0\3\6\6\0\7\6\1\100"+
    "\15\6\15\0\3\6\6\0\15\6\1\101\7\6\61\0"+
    "\1\102\12\0\1\50\46\0\3\6\6\0\2\6\1\103"+
    "\22\6\15\0\3\6\6\0\5\6\1\104\17\6\15\0"+
    "\3\6\6\0\13\6\1\105\11\6\15\0\3\6\6\0"+
    "\11\6\1\106\13\6\15\0\3\6\6\0\12\6\1\107"+
    "\12\6\15\0\3\6\6\0\4\6\1\110\20\6\15\0"+
    "\3\6\6\0\16\6\1\111\6\6\15\0\3\6\6\0"+
    "\1\6\1\112\23\6\15\0\3\6\6\0\17\6\1\113"+
    "\5\6\15\0\3\6\6\0\15\6\1\114\7\6\15\0"+
    "\3\6\6\0\6\6\1\115\16\6\15\0\3\6\6\0"+
    "\4\6\1\116\20\6\15\0\3\6\6\0\10\6\1\117"+
    "\14\6\15\0\3\6\6\0\5\6\1\120\17\6\15\0"+
    "\3\6\6\0\15\6\1\121\7\6\15\0\3\6\6\0"+
    "\3\6\1\122\21\6\15\0\3\6\6\0\3\6\1\123"+
    "\21\6\15\0\3\6\6\0\6\6\1\124\16\6\15\0"+
    "\3\6\6\0\1\6\1\125\23\6\15\0\3\6\6\0"+
    "\1\6\1\126\23\6\15\0\3\6\6\0\11\6\1\127"+
    "\13\6\15\0\3\6\6\0\1\6\1\130\23\6\15\0"+
    "\3\6\6\0\4\6\1\131\20\6\15\0\3\6\6\0"+
    "\1\6\1\132\23\6\15\0\3\6\6\0\11\6\1\133"+
    "\13\6\15\0\3\6\6\0\10\6\1\134\14\6\15\0"+
    "\3\6\6\0\5\6\1\135\17\6\15\0\3\6\6\0"+
    "\2\6\1\136\5\6\1\137\14\6\15\0\3\6\6\0"+
    "\12\6\1\140\12\6\15\0\3\6\6\0\4\6\1\141"+
    "\20\6\15\0\3\6\6\0\1\6\1\142\23\6\15\0"+
    "\3\6\6\0\2\6\1\143\22\6\15\0\3\6\6\0"+
    "\12\6\1\144\12\6\15\0\3\6\6\0\1\6\1\145"+
    "\23\6\15\0\3\6\6\0\12\6\1\146\12\6\15\0"+
    "\3\6\6\0\15\6\1\147\7\6\15\0\3\6\6\0"+
    "\15\6\1\150\7\6\15\0\3\6\6\0\1\6\1\151"+
    "\23\6\15\0\3\6\6\0\1\6\1\152\23\6\15\0"+
    "\3\6\6\0\7\6\1\153\15\6\15\0\3\6\6\0"+
    "\1\6\1\154\23\6\15\0\3\6\6\0\3\6\1\155"+
    "\21\6\15\0\3\6\6\0\13\6\1\156\11\6\15\0"+
    "\3\6\6\0\7\6\1\157\15\6\15\0\3\6\6\0"+
    "\13\6\1\160\11\6\15\0\3\6\6\0\6\6\1\161"+
    "\16\6\15\0\3\6\6\0\4\6\1\162\20\6\15\0"+
    "\3\6\6\0\15\6\1\163\7\6\15\0\3\6\6\0"+
    "\5\6\1\164\17\6\15\0\3\6\6\0\20\6\1\165"+
    "\4\6\15\0\3\6\6\0\16\6\1\166\6\6\15\0"+
    "\3\6\6\0\4\6\1\167\20\6\15\0\3\6\6\0"+
    "\4\6\1\170\20\6\15\0\3\6\6\0\15\6\1\171"+
    "\7\6\15\0\3\6\6\0\1\6\1\172\23\6\14\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3354];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\1\11\2\1\1\11\1\1\2\11\1\1\1\11"+
    "\14\1\5\11\1\1\11\11\1\1\4\11\24\1\1\11"+
    "\70\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[122];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  // Variable para almacenar las cadenas de caracteres encerradas entre comillas
  StringBuffer cadenaCaracteres = new StringBuffer();
  
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;

  private Token token(int tipo) 
    {
	 Token token = new Token (tipo);
         token.setLine (yyline + 1);
         token.setColumn (yycolumn + 1);
         token.setLexema (yytext ());
         return token;
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 166) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexicalError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexicalError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, LexicalError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 34: 
          { return token (sym.ELSE);
          }
        case 49: break;
        case 4: 
          { // Ignorar
          }
        case 50: break;
        case 5: 
          { // Cambio de estado
						    yybegin(COMENTARIO_ENTRE_LLAVES);
          }
        case 51: break;
        case 18: 
          { return token (sym.ARROBA);
          }
        case 52: break;
        case 36: 
          { return token (sym.THEN);
          }
        case 53: break;
        case 20: 
          { LexicalError error = new LexicalError ("Comentario anidado encontrado");
                        			   error.setLine (yyline + 1);
						   error.setColumn (yycolumn + 1);
						   error.setLexema (yytext ());
						   lexicalErrorManager.lexicalFatalError (error);
          }
        case 54: break;
        case 45: 
          { return token (sym.PROGRAM);
          }
        case 55: break;
        case 1: 
          { LexicalError error = new LexicalError ("Token no reconocido: " + yytext());
				           error.setLine (yyline + 1);
				           error.setColumn (yycolumn + 1);
				           error.setLexema (yytext ());
				           lexicalErrorManager.lexicalFatalError (error);
          }
        case 56: break;
        case 10: 
          { return token (sym.COMA);
          }
        case 57: break;
        case 6: 
          { // Limpiamos el StringBuffer donde guardaremos la cadena de caracteres
							cadenaCaracteres.setLength(0);
							// Cambio de estado
						    yybegin(CADENA_CARACTERES);
          }
        case 58: break;
        case 22: 
          { LexicalError error = new LexicalError ("Caracter no permitido en comentario de l�nea");
						   error.setLine (yyline + 1);
						   error.setColumn (yycolumn + 1);
						   error.setLexema (yytext ());
						   lexicalErrorManager.lexicalFatalError (error);
          }
        case 59: break;
        case 9: 
          { // Error, hemos encontrado un cierre de comentario sin la apertura previa
                           LexicalError error = new LexicalError ("Cierre de comentario encontrado sin apertura previa");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalFatalError (error);
          }
        case 60: break;
        case 24: 
          { yybegin(YYINITIAL);
							
						    Token token = new Token (sym.LITERAL_CADENA);
						    token.setLine (yyline + 1);
						    token.setColumn (yycolumn + 1);
						    token.setLexema (cadenaCaracteres.toString());
		            			    return token;
          }
        case 61: break;
        case 3: 
          { Token token = new Token (sym.LITERAL_ENTERO);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
          }
        case 62: break;
        case 33: 
          { return token (sym.VAR);
          }
        case 63: break;
        case 28: 
          { return token (sym.TO);
          }
        case 64: break;
        case 21: 
          { yybegin(YYINITIAL);
          }
        case 65: break;
        case 8: 
          { return token (sym.PARENT_CERRAR);
          }
        case 66: break;
        case 39: 
          { return token (sym.CONST);
          }
        case 67: break;
        case 15: 
          { return token (sym.MAYOR_QUE);
          }
        case 68: break;
        case 19: 
          { // Ignorar cualquier otro caracter dentro del comentario
          }
        case 69: break;
        case 40: 
          { return token (sym.FALSE);
          }
        case 70: break;
        case 32: 
          { return token (sym.FOR);
          }
        case 71: break;
        case 41: 
          { return token (sym.WRITE);
          }
        case 72: break;
        case 16: 
          { return token (sym.PUNTO);
          }
        case 73: break;
        case 30: 
          { return token (sym.DOS_PUNTOS_IGUAL);
          }
        case 74: break;
        case 38: 
          { return token(sym.BEGIN);
          }
        case 75: break;
        case 11: 
          { return token (sym.PUNTO_Y_COMA);
          }
        case 76: break;
        case 17: 
          { return token (sym.CIRCUNFLEJO);
          }
        case 77: break;
        case 12: 
          { return token (sym.DOS_PUNTOS);
          }
        case 78: break;
        case 7: 
          { return token (sym.PARENT_ABRIR);
          }
        case 79: break;
        case 43: 
          { return token(sym.BOOLEAN);
          }
        case 80: break;
        case 14: 
          { return token (sym.MENOS);
          }
        case 81: break;
        case 48: 
          { return token (sym.PROCEDURE);
          }
        case 82: break;
        case 29: 
          { return token (sym.DO);
          }
        case 83: break;
        case 46: 
          { return token (sym.WRITELN);
          }
        case 84: break;
        case 42: 
          { return token (sym.RECORD);
          }
        case 85: break;
        case 23: 
          { // A�adir al buffer de la cadena de caracteres
    						cadenaCaracteres.append(yytext());
          }
        case 86: break;
        case 26: 
          { return token (sym.IF);
          }
        case 87: break;
        case 13: 
          { return token (sym.IGUAL);
          }
        case 88: break;
        case 47: 
          { return token (sym.FUNCTION);
          }
        case 89: break;
        case 25: 
          { // Cambio de estado
						    yybegin(COMENTARIO_UNA_LINEA);
          }
        case 90: break;
        case 44: 
          { return token (sym.INTEGER);
          }
        case 91: break;
        case 35: 
          { return token (sym.TRUE);
          }
        case 92: break;
        case 31: 
          { return token (sym.END);
          }
        case 93: break;
        case 2: 
          { return token(sym.ID);
          }
        case 94: break;
        case 27: 
          { return token (sym.OR);
          }
        case 95: break;
        case 37: 
          { return token (sym.TYPE);
          }
        case 96: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case CADENA_CARACTERES: {
              LexicalError error = new LexicalError ("Cadena de caracteres no cerrada antes de fin de fichero");
						   error.setLine (yyline + 1);
						   error.setColumn (yycolumn + 1);
						   error.setLexema (yytext ());
						   lexicalErrorManager.lexicalFatalError (error);
            }
            case 123: break;
            case COMENTARIO_ENTRE_LLAVES: {
              LexicalError error = new LexicalError ("Comentario no cerrado antes de fin de fichero");
						   error.setLine (yyline + 1);
						   error.setColumn (yycolumn + 1);
						   error.setLexema (yytext ());
						   lexicalErrorManager.lexicalFatalError (error);
            }
            case 124: break;
            default:
              { return new java_cup.runtime.Symbol(sym.EOF); }
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
