grammar EasyLanguage;

@header{
	import br.edu.cefsa.compiler.datastructures.EasySymbol;
	import br.edu.cefsa.compiler.datastructures.EasyVariable;
	import br.edu.cefsa.compiler.datastructures.EasyFunction;
	import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
	import br.edu.cefsa.compiler.exceptions.EasySemanticException;
	import br.edu.cefsa.compiler.abstractsyntaxtree.*;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private EasySymbolTable symbolTable = new EasySymbolTable();
	private EasySymbol symbol;
	private EasyProgram program = new EasyProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> listaWhile;
	private ArrayList<AbstractCommand> listaFor;
	private String _functionName;
	private ArrayList<EasyVariable> _parameters;
	private int _returnType;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new EasySemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void verificaTipo(String id, int expectedType){
		if (!symbolTable.exists(id)){
			throw new EasySemanticException("Symbol "+id+" not declared");
		}
		EasyVariable var = (EasyVariable)symbolTable.get(id);
		if (var.getType() != expectedType){
			throw new EasySemanticException("Type mismatch for symbol "+id);
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

// REGRA PRINCIPAL
prog	: 'programa' ID 
          (declaracao)*
          'inicio'
          bloco 
          'fim;'
          {  
              program.setVarTable(symbolTable);
              program.setComandos(stack.pop());
          } 
	;

// DECLARAÇÕES
declaracao : declaravar
           | declarafuncao
           | declaraconst
           ;

// DECLARAÇÃO DE VARIÁVEIS (expandida)
declaravar : tipo ID {
                  _varName = _input.LT(-1).getText();
                  _varValue = null;
                  symbol = new EasyVariable(_varName, _tipo, _varValue);
                  if (!symbolTable.exists(_varName)){
                     symbolTable.add(symbol);	
                  }
                  else{
                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
                  }
             } 
             (ATTR 
              (NUMBER { _varValue = _input.LT(-1).getText(); }
              | STRING { _varValue = _input.LT(-1).getText(); }
              | BOOLEAN { _varValue = _input.LT(-1).getText(); }
              | CHAR { _varValue = _input.LT(-1).getText(); }
              )
             )?
             (VIR 
              ID {
                  _varName = _input.LT(-1).getText();
                  _varValue = null;
                  symbol = new EasyVariable(_varName, _tipo, _varValue);
                  if (!symbolTable.exists(_varName)){
                     symbolTable.add(symbol);	
                  }
                  else{
                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
                  }
              }
              (ATTR 
               (NUMBER { _varValue = _input.LT(-1).getText(); }
               | STRING { _varValue = _input.LT(-1).getText(); }
               | BOOLEAN { _varValue = _input.LT(-1).getText(); }
               | CHAR { _varValue = _input.LT(-1).getText(); }
               )
              )?
             )* 
             SC
           ;

// DECLARAÇÃO DE CONSTANTES
declaraconst : 'const' tipo ID ATTR 
               (NUMBER | STRING | BOOLEAN | CHAR)
               SC
             ;

// DECLARAÇÃO DE FUNÇÕES
declarafuncao : (tipo | 'vazio') 'funcao' ID {
                    _functionName = _input.LT(-1).getText();
                    _parameters = new ArrayList<EasyVariable>();
                }
                AP 
                (parametros)?
                FP
                'inicio'
                bloco
                'fim' SC
                {
                    EasyFunction func = new EasyFunction(_functionName, _returnType, _parameters);
                    symbolTable.add(func);
                }
              ;

parametros : tipo ID {
                 _parameters.add(new EasyVariable(_input.LT(-1).getText(), _tipo, null));
             }
             (VIR tipo ID {
                 _parameters.add(new EasyVariable(_input.LT(-1).getText(), _tipo, null));
             })*
           ;

// TIPOS EXPANDIDOS
tipo : 'inteiro'   { _tipo = EasyVariable.INTEGER; }
     | 'real'      { _tipo = EasyVariable.REAL; }
     | 'texto'     { _tipo = EasyVariable.TEXT; }
     | 'caractere' { _tipo = EasyVariable.CHAR; }
     | 'logico'    { _tipo = EasyVariable.BOOLEAN; }
     | 'vetor'     { _tipo = EasyVariable.ARRAY; }
     ;

// BLOCO DE COMANDOS
bloco : { 
          curThread = new ArrayList<AbstractCommand>(); 
          stack.push(curThread);  
        }
        (cmd)*
      ;

// COMANDOS EXPANDIDOS
cmd : cmdleitura  
    | cmdescrita 
    | cmdattrib
    | cmdselecao
    | cmdrepeticao
    | cmdfor
    | cmdretorno
    | cmdchamada
    ;

// COMANDO DE LEITURA
cmdleitura : 'leia' AP
             ID { 
                 verificaID(_input.LT(-1).getText());
                 _readID = _input.LT(-1).getText();
             } 
             FP SC 
             {
                 EasyVariable var = (EasyVariable)symbolTable.get(_readID);
                 CommandLeitura cmd = new CommandLeitura(_readID, var);
                 stack.peek().add(cmd);
             }   
           ;

// COMANDO DE ESCRITA
cmdescrita : 'escreva' AP 
             (ID { 
                 verificaID(_input.LT(-1).getText());
                 _writeID = _input.LT(-1).getText();
             }
             | STRING { _writeID = _input.LT(-1).getText(); }
             ) 
             FP SC
             {
                 CommandEscrita cmd = new CommandEscrita(_writeID);
                 stack.peek().add(cmd);
             }
           ;

// COMANDO DE ATRIBUIÇÃO
cmdattrib : ID { 
                verificaID(_input.LT(-1).getText());
                _exprID = _input.LT(-1).getText();
            } 
            ATTR { _exprContent = ""; } 
            expr 
            SC
            {
                CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
                stack.peek().add(cmd);
            }
          ;

// COMANDO DE SELEÇÃO (SE-SENAO)
cmdselecao : 'se' AP
             expr_logica { _exprDecision = _exprContent; }
             FP 
             'entao'
             ACH 
             { 
                 curThread = new ArrayList<AbstractCommand>(); 
                 stack.push(curThread);
             }
             (cmd)* 
             FCH
             {
                listaTrue = stack.pop();	
             } 
             ('senao' 
              ACH
              {
                  curThread = new ArrayList<AbstractCommand>();
                  stack.push(curThread);
              } 
              (cmd)* 
              FCH
              {
                  listaFalse = stack.pop();
              }
             )?
             {
                 CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                 stack.peek().add(cmd);
             }
           ;

// COMANDO DE REPETIÇÃO (ENQUANTO)
cmdrepeticao : 'enquanto' AP
               expr_logica { _exprDecision = _exprContent; }
               FP
               'faca'
               ACH
               {
                   curThread = new ArrayList<AbstractCommand>();
                   stack.push(curThread);
               }
               (cmd)*
               FCH
               {
                   listaWhile = stack.pop();
                   CommandRepeticao cmd = new CommandRepeticao(_exprDecision, listaWhile);
                   stack.peek().add(cmd);
               }
             ;

// COMANDO FOR
cmdfor : 'para' ID ATTR expr 'ate' expr ('passo' expr)? 'faca'
         ACH
         {
             curThread = new ArrayList<AbstractCommand>();
             stack.push(curThread);
         }
         (cmd)*
         FCH
         {
             listaFor = stack.pop();
             CommandFor cmd = new CommandFor(_exprID, _exprContent, listaFor);
             stack.peek().add(cmd);
         }
       ;

// COMANDO DE RETORNO
cmdretorno : 'retorna' expr? SC
           ;

// CHAMADA DE FUNÇÃO
cmdchamada : ID AP (expr (VIR expr)*)? FP SC
           ;

// EXPRESSÕES LÓGICAS
expr_logica : expr_relacional (('e' | 'ou') expr_relacional)*
            ;

expr_relacional : expr (OPREL expr)?
                ;

// EXPRESSÕES ARITMÉTICAS
expr : termo ( 
           OP { _exprContent += _input.LT(-1).getText(); }
           termo
       )*
     ;

termo : fator (
            ('*' | '/' | '%') { _exprContent += _input.LT(-1).getText(); }
            fator
        )*
      ;

fator : ID { 
            verificaID(_input.LT(-1).getText());
            _exprContent += _input.LT(-1).getText();
        }
      | NUMBER { _exprContent += _input.LT(-1).getText(); }
      | STRING { _exprContent += _input.LT(-1).getText(); }
      | BOOLEAN { _exprContent += _input.LT(-1).getText(); }
      | CHAR { _exprContent += _input.LT(-1).getText(); }
      | AP expr FP
      | chamada_funcao
      ;

chamada_funcao : ID AP (expr (VIR expr)*)? FP
               ;

// TOKENS
AP    : '(' ;
FP    : ')' ;
SC    : ';' ;
OP    : '+' | '-' ;
ATTR  : '=' ;
VIR   : ',' ;
ACH   : '{' ;
FCH   : '}' ;

OPREL : '>' | '<' | '>=' | '<=' | '==' | '!=' ;

// TIPOS DE DADOS
ID      : [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER  : [0-9]+ ('.' [0-9]+)? ;
STRING  : '"' (~["\r\n])* '"' ;
BOOLEAN : 'verdadeiro' | 'falso' ;
CHAR    : '\'' . '\'' ;

// COMENTÁRIOS
COMMENT_LINE  : '//' ~[\r\n]* -> skip ;
COMMENT_BLOCK : '/*' .*? '*/' -> skip ;

// ESPAÇOS EM BRANCO
WS : [ \t\r\n]+ -> skip ;