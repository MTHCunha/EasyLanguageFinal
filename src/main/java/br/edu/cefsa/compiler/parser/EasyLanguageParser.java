// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package br.edu.cefsa.compiler.parser;

	import br.edu.cefsa.compiler.datastructures.EasySymbol;
	import br.edu.cefsa.compiler.datastructures.EasyVariable;
	import br.edu.cefsa.compiler.datastructures.EasyFunction;
	import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
	import br.edu.cefsa.compiler.exceptions.EasySemanticException;
	import br.edu.cefsa.compiler.abstractsyntaxtree.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, AP=30, FP=31, SC=32, 
		OP=33, ATTR=34, VIR=35, ACH=36, FCH=37, OPREL=38, ID=39, NUMBER=40, STRING=41, 
		BOOLEAN=42, CHAR=43, COMMENT_LINE=44, COMMENT_BLOCK=45, WS=46;
	public static final int
		RULE_prog = 0, RULE_declaracao = 1, RULE_declaravar = 2, RULE_declaraconst = 3, 
		RULE_declarafuncao = 4, RULE_parametros = 5, RULE_tipo = 6, RULE_bloco = 7, 
		RULE_cmd = 8, RULE_cmdleitura = 9, RULE_cmdescrita = 10, RULE_cmdattrib = 11, 
		RULE_cmdselecao = 12, RULE_cmdrepeticao = 13, RULE_cmdfor = 14, RULE_cmdretorno = 15, 
		RULE_cmdchamada = 16, RULE_expr_logica = 17, RULE_expr_relacional = 18, 
		RULE_expr = 19, RULE_termo = 20, RULE_fator = 21, RULE_chamada_funcao = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declaracao", "declaravar", "declaraconst", "declarafuncao", 
			"parametros", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", "cmdattrib", 
			"cmdselecao", "cmdrepeticao", "cmdfor", "cmdretorno", "cmdchamada", "expr_logica", 
			"expr_relacional", "expr", "termo", "fator", "chamada_funcao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim;'", "'const'", "'vazio'", "'funcao'", 
			"'fim'", "'inteiro'", "'real'", "'texto'", "'caractere'", "'logico'", 
			"'vetor'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'faca'", "'para'", "'ate'", "'passo'", "'retorna'", "'e'", "'ou'", "'*'", 
			"'/'", "'%'", "'('", "')'", "';'", null, "'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", 
			"ACH", "FCH", "OPREL", "ID", "NUMBER", "STRING", "BOOLEAN", "CHAR", "COMMENT_LINE", 
			"COMMENT_BLOCK", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private String _varName;
		private String _varValue;
		public EasySymbolTable symbolTable = new EasySymbolTable();
		public EasySymbol symbol;
		public EasyProgram program = new EasyProgram();
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

	public EasyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			match(ID);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16176L) != 0)) {
				{
				{
				setState(48);
				declaracao();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__1);
			setState(55);
			bloco();
			setState(56);
			match(T__2);
			  
			              program.setVarTable(symbolTable);
			              program.setComandos(stack.pop());
			          
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public DeclaravarContext declaravar() {
			return getRuleContext(DeclaravarContext.class,0);
		}
		public DeclarafuncaoContext declarafuncao() {
			return getRuleContext(DeclarafuncaoContext.class,0);
		}
		public DeclaraconstContext declaraconst() {
			return getRuleContext(DeclaraconstContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				declaravar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				declarafuncao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				declaraconst();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<TerminalNode> ATTR() { return getTokens(EasyLanguageParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(EasyLanguageParser.ATTR, i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(EasyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EasyLanguageParser.NUMBER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(EasyLanguageParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EasyLanguageParser.STRING, i);
		}
		public List<TerminalNode> BOOLEAN() { return getTokens(EasyLanguageParser.BOOLEAN); }
		public TerminalNode BOOLEAN(int i) {
			return getToken(EasyLanguageParser.BOOLEAN, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(EasyLanguageParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(EasyLanguageParser.CHAR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			tipo();
			setState(65);
			match(ID);

			                  _varName = _input.LT(-1).getText();
			                  _varValue = null;
			                  symbol = new EasyVariable(_varName, _tipo, _varValue);
			                  if (!symbolTable.exists(_varName)){
			                     symbolTable.add(symbol);	
			                  }
			                  else{
			                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
			                  }
			             
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(67);
				match(ATTR);
				setState(76);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUMBER:
					{
					setState(68);
					match(NUMBER);
					 _varValue = _input.LT(-1).getText(); 
					}
					break;
				case STRING:
					{
					setState(70);
					match(STRING);
					 _varValue = _input.LT(-1).getText(); 
					}
					break;
				case BOOLEAN:
					{
					setState(72);
					match(BOOLEAN);
					 _varValue = _input.LT(-1).getText(); 
					}
					break;
				case CHAR:
					{
					setState(74);
					match(CHAR);
					 _varValue = _input.LT(-1).getText(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(80);
				match(VIR);
				setState(81);
				match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new EasyVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
				                  }
				              
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATTR) {
					{
					setState(83);
					match(ATTR);
					setState(92);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NUMBER:
						{
						setState(84);
						match(NUMBER);
						 _varValue = _input.LT(-1).getText(); 
						}
						break;
					case STRING:
						{
						setState(86);
						match(STRING);
						 _varValue = _input.LT(-1).getText(); 
						}
						break;
					case BOOLEAN:
						{
						setState(88);
						match(BOOLEAN);
						 _varValue = _input.LT(-1).getText(); 
						}
						break;
					case CHAR:
						{
						setState(90);
						match(CHAR);
						 _varValue = _input.LT(-1).getText(); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraconstContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(EasyLanguageParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(EasyLanguageParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(EasyLanguageParser.CHAR, 0); }
		public DeclaraconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclaraconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclaraconst(this);
		}
	}

	public final DeclaraconstContext declaraconst() throws RecognitionException {
		DeclaraconstContext _localctx = new DeclaraconstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaraconst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__3);
			setState(104);
			tipo();
			setState(105);
			match(ID);
			setState(106);
			match(ATTR);
			setState(107);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(108);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarafuncaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public DeclarafuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarafuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclarafuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclarafuncao(this);
		}
	}

	public final DeclarafuncaoContext declarafuncao() throws RecognitionException {
		DeclarafuncaoContext _localctx = new DeclarafuncaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarafuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				{
				setState(110);
				tipo();
				}
				break;
			case T__4:
				{
				setState(111);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(114);
			match(T__5);
			setState(115);
			match(ID);

			                    _functionName = _input.LT(-1).getText();
			                    _parameters = new ArrayList<EasyVariable>();
			                
			setState(117);
			match(AP);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16128L) != 0)) {
				{
				setState(118);
				parametros();
				}
			}

			setState(121);
			match(FP);
			setState(122);
			match(T__1);
			setState(123);
			bloco();
			setState(124);
			match(T__6);
			setState(125);
			match(SC);

			                    EasyFunction func = new EasyFunction(_functionName, _returnType, _parameters);
			                    symbolTable.add(func);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitParametros(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			tipo();
			setState(129);
			match(ID);

			                 _parameters.add(new EasyVariable(_input.LT(-1).getText(), _tipo, null));
			             
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(131);
				match(VIR);
				setState(132);
				tipo();
				setState(133);
				match(ID);

				                 _parameters.add(new EasyVariable(_input.LT(-1).getText(), _tipo, null));
				             
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(T__7);
				 _tipo = EasyVariable.INTEGER; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(T__8);
				 _tipo = EasyVariable.REAL; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				match(T__9);
				 _tipo = EasyVariable.TEXT; 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(T__10);
				 _tipo = EasyVariable.CHAR; 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(T__11);
				 _tipo = EasyVariable.BOOLEAN; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				match(T__12);
				 _tipo = EasyVariable.ARRAY; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			          curThread = new ArrayList<AbstractCommand>(); 
			          stack.push(curThread);  
			        
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549775327232L) != 0)) {
				{
				{
				setState(156);
				cmd();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdforContext cmdfor() {
			return getRuleContext(CmdforContext.class,0);
		}
		public CmdretornoContext cmdretorno() {
			return getRuleContext(CmdretornoContext.class,0);
		}
		public CmdchamadaContext cmdchamada() {
			return getRuleContext(CmdchamadaContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				cmdleitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				cmdselecao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				cmdrepeticao();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				cmdfor();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				cmdretorno();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(169);
				cmdchamada();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__13);
			setState(173);
			match(AP);
			setState(174);
			match(ID);
			 
			                 verificaID(_input.LT(-1).getText());
			                 _readID = _input.LT(-1).getText();
			             
			setState(176);
			match(FP);
			setState(177);
			match(SC);

			                 EasyVariable var = (EasyVariable)symbolTable.get(_readID);
			                 CommandLeitura cmd = new CommandLeitura(_readID, var);
			                 stack.peek().add(cmd);
			             
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode STRING() { return getToken(EasyLanguageParser.STRING, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__14);
			setState(181);
			match(AP);
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(182);
				match(ID);
				 
				                 verificaID(_input.LT(-1).getText());
				                 _writeID = _input.LT(-1).getText();
				             
				}
				break;
			case STRING:
				{
				setState(184);
				match(STRING);
				 _writeID = _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(188);
			match(FP);
			setState(189);
			match(SC);

			                 CommandEscrita cmd = new CommandEscrita(_writeID);
			                 stack.peek().add(cmd);
			             
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ID);
			 
			                verificaID(_input.LT(-1).getText());
			                _exprID = _input.LT(-1).getText();
			            
			setState(194);
			match(ATTR);
			 _exprContent = ""; 
			setState(196);
			expr();
			setState(197);
			match(SC);

			                CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			                stack.peek().add(cmd);
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(EasyLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(EasyLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(EasyLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(EasyLanguageParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__15);
			setState(201);
			match(AP);
			setState(202);
			expr_logica();
			 _exprDecision = _exprContent; 
			setState(204);
			match(FP);
			setState(205);
			match(T__16);
			setState(206);
			match(ACH);
			 
			                 curThread = new ArrayList<AbstractCommand>(); 
			                 stack.push(curThread);
			             
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549775327232L) != 0)) {
				{
				{
				setState(208);
				cmd();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214);
			match(FCH);

			                listaTrue = stack.pop();	
			             
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(216);
				match(T__17);
				setState(217);
				match(ACH);

				                  curThread = new ArrayList<AbstractCommand>();
				                  stack.push(curThread);
				              
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549775327232L) != 0)) {
					{
					{
					setState(219);
					cmd();
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(225);
				match(FCH);

				                  listaFalse = stack.pop();
				              
				}
			}


			                 CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                 stack.peek().add(cmd);
			             
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__18);
			setState(232);
			match(AP);
			setState(233);
			expr_logica();
			 _exprDecision = _exprContent; 
			setState(235);
			match(FP);
			setState(236);
			match(T__19);
			setState(237);
			match(ACH);

			                   curThread = new ArrayList<AbstractCommand>();
			                   stack.push(curThread);
			               
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549775327232L) != 0)) {
				{
				{
				setState(239);
				cmd();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
			match(FCH);

			                   listaWhile = stack.pop();
			                   CommandRepeticao cmd = new CommandRepeticao(_exprDecision, listaWhile);
			                   stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdforContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdfor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdfor(this);
		}
	}

	public final CmdforContext cmdfor() throws RecognitionException {
		CmdforContext _localctx = new CmdforContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__20);
			setState(249);
			match(ID);
			setState(250);
			match(ATTR);
			setState(251);
			expr();
			setState(252);
			match(T__21);
			setState(253);
			expr();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(254);
				match(T__22);
				setState(255);
				expr();
				}
			}

			setState(258);
			match(T__19);
			setState(259);
			match(ACH);

			             curThread = new ArrayList<AbstractCommand>();
			             stack.push(curThread);
			         
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549775327232L) != 0)) {
				{
				{
				setState(261);
				cmd();
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
			match(FCH);

			             listaFor = stack.pop();
			             CommandFor cmd = new CommandFor(_exprID, _exprContent, listaFor);
			             stack.peek().add(cmd);
			         
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdretornoContext extends ParserRuleContext {
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdretornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdretorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdretorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdretorno(this);
		}
	}

	public final CmdretornoContext cmdretorno() throws RecognitionException {
		CmdretornoContext _localctx = new CmdretornoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdretorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__23);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17043503972352L) != 0)) {
				{
				setState(271);
				expr();
				}
			}

			setState(274);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdchamadaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public CmdchamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdchamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdchamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdchamada(this);
		}
	}

	public final CmdchamadaContext cmdchamada() throws RecognitionException {
		CmdchamadaContext _localctx = new CmdchamadaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cmdchamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ID);
			setState(277);
			match(AP);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17043503972352L) != 0)) {
				{
				setState(278);
				expr();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(279);
					match(VIR);
					setState(280);
					expr();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(288);
			match(FP);
			setState(289);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_logicaContext extends ParserRuleContext {
		public List<Expr_relacionalContext> expr_relacional() {
			return getRuleContexts(Expr_relacionalContext.class);
		}
		public Expr_relacionalContext expr_relacional(int i) {
			return getRuleContext(Expr_relacionalContext.class,i);
		}
		public Expr_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExpr_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExpr_logica(this);
		}
	}

	public final Expr_logicaContext expr_logica() throws RecognitionException {
		Expr_logicaContext _localctx = new Expr_logicaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_logica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			expr_relacional();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24 || _la==T__25) {
				{
				{
				setState(292);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(293);
				expr_relacional();
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_relacionalContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public Expr_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExpr_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExpr_relacional(this);
		}
	}

	public final Expr_relacionalContext expr_relacional() throws RecognitionException {
		Expr_relacionalContext _localctx = new Expr_relacionalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			expr();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(300);
				match(OPREL);
				setState(301);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(EasyLanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(EasyLanguageParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			termo();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(305);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(307);
				termo();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			fator();
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) {
				{
				{
				setState(314);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 _exprContent += _input.LT(-1).getText(); 
				setState(316);
				fator();
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(EasyLanguageParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(EasyLanguageParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(EasyLanguageParser.CHAR, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public Chamada_funcaoContext chamada_funcao() {
			return getRuleContext(Chamada_funcaoContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fator);
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(ID);
				 
				            verificaID(_input.LT(-1).getText());
				            _exprContent += _input.LT(-1).getText();
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(NUMBER);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				match(STRING);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				match(BOOLEAN);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				match(CHAR);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(332);
				match(AP);
				setState(333);
				expr();
				setState(334);
				match(FP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(336);
				chamada_funcao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Chamada_funcaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public Chamada_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterChamada_funcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitChamada_funcao(this);
		}
	}

	public final Chamada_funcaoContext chamada_funcao() throws RecognitionException {
		Chamada_funcaoContext _localctx = new Chamada_funcaoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_chamada_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(ID);
			setState(340);
			match(AP);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17043503972352L) != 0)) {
				{
				setState(341);
				expr();
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(342);
					match(VIR);
					setState(343);
					expr();
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(351);
			match(FP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u0162\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"2\b\u0000\n\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"?\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002M\b\u0002\u0003\u0002O\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002]\b"+
		"\u0002\u0003\u0002_\b\u0002\u0005\u0002a\b\u0002\n\u0002\f\u0002d\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004"+
		"q\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004x\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0089\b\u0005\n\u0005\f\u0005\u008c\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009a\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u009e\b\u0007\n\u0007\f\u0007\u00a1\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00ab\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00d2\b\f\n"+
		"\f\f\f\u00d5\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u00dd\b\f\n\f\f\f\u00e0\t\f\u0001\f\u0001\f\u0003\f\u00e4\b\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00f1\b\r\n\r\f\r\u00f4\t\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0101\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0107\b\u000e\n\u000e\f\u000e\u010a"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u0111\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u011a\b\u0010\n\u0010\f\u0010"+
		"\u011d\t\u0010\u0003\u0010\u011f\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0127\b\u0011\n"+
		"\u0011\f\u0011\u012a\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u012f\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u0135\b\u0013\n\u0013\f\u0013\u0138\t\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u013e\b\u0014\n\u0014\f\u0014\u0141"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0152\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0159"+
		"\b\u0016\n\u0016\f\u0016\u015c\t\u0016\u0003\u0016\u015e\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000"+
		"\u0003\u0001\u0000(+\u0001\u0000\u0019\u001a\u0001\u0000\u001b\u001d\u017c"+
		"\u0000.\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000\u0000\u0004@"+
		"\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000\bp\u0001\u0000"+
		"\u0000\u0000\n\u0080\u0001\u0000\u0000\u0000\f\u0099\u0001\u0000\u0000"+
		"\u0000\u000e\u009b\u0001\u0000\u0000\u0000\u0010\u00aa\u0001\u0000\u0000"+
		"\u0000\u0012\u00ac\u0001\u0000\u0000\u0000\u0014\u00b4\u0001\u0000\u0000"+
		"\u0000\u0016\u00c0\u0001\u0000\u0000\u0000\u0018\u00c8\u0001\u0000\u0000"+
		"\u0000\u001a\u00e7\u0001\u0000\u0000\u0000\u001c\u00f8\u0001\u0000\u0000"+
		"\u0000\u001e\u010e\u0001\u0000\u0000\u0000 \u0114\u0001\u0000\u0000\u0000"+
		"\"\u0123\u0001\u0000\u0000\u0000$\u012b\u0001\u0000\u0000\u0000&\u0130"+
		"\u0001\u0000\u0000\u0000(\u0139\u0001\u0000\u0000\u0000*\u0151\u0001\u0000"+
		"\u0000\u0000,\u0153\u0001\u0000\u0000\u0000./\u0005\u0001\u0000\u0000"+
		"/3\u0005\'\u0000\u000002\u0003\u0002\u0001\u000010\u0001\u0000\u0000\u0000"+
		"25\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005\u0002"+
		"\u0000\u000078\u0003\u000e\u0007\u000089\u0005\u0003\u0000\u00009:\u0006"+
		"\u0000\uffff\uffff\u0000:\u0001\u0001\u0000\u0000\u0000;?\u0003\u0004"+
		"\u0002\u0000<?\u0003\b\u0004\u0000=?\u0003\u0006\u0003\u0000>;\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0003"+
		"\u0001\u0000\u0000\u0000@A\u0003\f\u0006\u0000AB\u0005\'\u0000\u0000B"+
		"N\u0006\u0002\uffff\uffff\u0000CL\u0005\"\u0000\u0000DE\u0005(\u0000\u0000"+
		"EM\u0006\u0002\uffff\uffff\u0000FG\u0005)\u0000\u0000GM\u0006\u0002\uffff"+
		"\uffff\u0000HI\u0005*\u0000\u0000IM\u0006\u0002\uffff\uffff\u0000JK\u0005"+
		"+\u0000\u0000KM\u0006\u0002\uffff\uffff\u0000LD\u0001\u0000\u0000\u0000"+
		"LF\u0001\u0000\u0000\u0000LH\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000MO\u0001\u0000\u0000\u0000NC\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000Ob\u0001\u0000\u0000\u0000PQ\u0005#\u0000\u0000QR\u0005\'"+
		"\u0000\u0000R^\u0006\u0002\uffff\uffff\u0000S\\\u0005\"\u0000\u0000TU"+
		"\u0005(\u0000\u0000U]\u0006\u0002\uffff\uffff\u0000VW\u0005)\u0000\u0000"+
		"W]\u0006\u0002\uffff\uffff\u0000XY\u0005*\u0000\u0000Y]\u0006\u0002\uffff"+
		"\uffff\u0000Z[\u0005+\u0000\u0000[]\u0006\u0002\uffff\uffff\u0000\\T\u0001"+
		"\u0000\u0000\u0000\\V\u0001\u0000\u0000\u0000\\X\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^S\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`P\u0001\u0000"+
		"\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"ef\u0005 \u0000\u0000f\u0005\u0001\u0000\u0000\u0000gh\u0005\u0004\u0000"+
		"\u0000hi\u0003\f\u0006\u0000ij\u0005\'\u0000\u0000jk\u0005\"\u0000\u0000"+
		"kl\u0007\u0000\u0000\u0000lm\u0005 \u0000\u0000m\u0007\u0001\u0000\u0000"+
		"\u0000nq\u0003\f\u0006\u0000oq\u0005\u0005\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0005\u0006"+
		"\u0000\u0000st\u0005\'\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000uw\u0005"+
		"\u001e\u0000\u0000vx\u0003\n\u0005\u0000wv\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u001f\u0000\u0000"+
		"z{\u0005\u0002\u0000\u0000{|\u0003\u000e\u0007\u0000|}\u0005\u0007\u0000"+
		"\u0000}~\u0005 \u0000\u0000~\u007f\u0006\u0004\uffff\uffff\u0000\u007f"+
		"\t\u0001\u0000\u0000\u0000\u0080\u0081\u0003\f\u0006\u0000\u0081\u0082"+
		"\u0005\'\u0000\u0000\u0082\u008a\u0006\u0005\uffff\uffff\u0000\u0083\u0084"+
		"\u0005#\u0000\u0000\u0084\u0085\u0003\f\u0006\u0000\u0085\u0086\u0005"+
		"\'\u0000\u0000\u0086\u0087\u0006\u0005\uffff\uffff\u0000\u0087\u0089\u0001"+
		"\u0000\u0000\u0000\u0088\u0083\u0001\u0000\u0000\u0000\u0089\u008c\u0001"+
		"\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u000b\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\b\u0000\u0000\u008e\u009a\u0006\u0006"+
		"\uffff\uffff\u0000\u008f\u0090\u0005\t\u0000\u0000\u0090\u009a\u0006\u0006"+
		"\uffff\uffff\u0000\u0091\u0092\u0005\n\u0000\u0000\u0092\u009a\u0006\u0006"+
		"\uffff\uffff\u0000\u0093\u0094\u0005\u000b\u0000\u0000\u0094\u009a\u0006"+
		"\u0006\uffff\uffff\u0000\u0095\u0096\u0005\f\u0000\u0000\u0096\u009a\u0006"+
		"\u0006\uffff\uffff\u0000\u0097\u0098\u0005\r\u0000\u0000\u0098\u009a\u0006"+
		"\u0006\uffff\uffff\u0000\u0099\u008d\u0001\u0000\u0000\u0000\u0099\u008f"+
		"\u0001\u0000\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u0093"+
		"\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\r\u0001\u0000\u0000\u0000\u009b\u009f\u0006"+
		"\u0007\uffff\uffff\u0000\u009c\u009e\u0003\u0010\b\u0000\u009d\u009c\u0001"+
		"\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u000f\u0001"+
		"\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00ab\u0003"+
		"\u0012\t\u0000\u00a3\u00ab\u0003\u0014\n\u0000\u00a4\u00ab\u0003\u0016"+
		"\u000b\u0000\u00a5\u00ab\u0003\u0018\f\u0000\u00a6\u00ab\u0003\u001a\r"+
		"\u0000\u00a7\u00ab\u0003\u001c\u000e\u0000\u00a8\u00ab\u0003\u001e\u000f"+
		"\u0000\u00a9\u00ab\u0003 \u0010\u0000\u00aa\u00a2\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a3\u0001\u0000\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a5\u0001\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a7\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u0011\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u000e\u0000\u0000\u00ad\u00ae\u0005\u001e\u0000\u0000"+
		"\u00ae\u00af\u0005\'\u0000\u0000\u00af\u00b0\u0006\t\uffff\uffff\u0000"+
		"\u00b0\u00b1\u0005\u001f\u0000\u0000\u00b1\u00b2\u0005 \u0000\u0000\u00b2"+
		"\u00b3\u0006\t\uffff\uffff\u0000\u00b3\u0013\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0005\u000f\u0000\u0000\u00b5\u00ba\u0005\u001e\u0000\u0000\u00b6"+
		"\u00b7\u0005\'\u0000\u0000\u00b7\u00bb\u0006\n\uffff\uffff\u0000\u00b8"+
		"\u00b9\u0005)\u0000\u0000\u00b9\u00bb\u0006\n\uffff\uffff\u0000\u00ba"+
		"\u00b6\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u001f\u0000\u0000\u00bd"+
		"\u00be\u0005 \u0000\u0000\u00be\u00bf\u0006\n\uffff\uffff\u0000\u00bf"+
		"\u0015\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\'\u0000\u0000\u00c1\u00c2"+
		"\u0006\u000b\uffff\uffff\u0000\u00c2\u00c3\u0005\"\u0000\u0000\u00c3\u00c4"+
		"\u0006\u000b\uffff\uffff\u0000\u00c4\u00c5\u0003&\u0013\u0000\u00c5\u00c6"+
		"\u0005 \u0000\u0000\u00c6\u00c7\u0006\u000b\uffff\uffff\u0000\u00c7\u0017"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0010\u0000\u0000\u00c9\u00ca"+
		"\u0005\u001e\u0000\u0000\u00ca\u00cb\u0003\"\u0011\u0000\u00cb\u00cc\u0006"+
		"\f\uffff\uffff\u0000\u00cc\u00cd\u0005\u001f\u0000\u0000\u00cd\u00ce\u0005"+
		"\u0011\u0000\u0000\u00ce\u00cf\u0005$\u0000\u0000\u00cf\u00d3\u0006\f"+
		"\uffff\uffff\u0000\u00d0\u00d2\u0003\u0010\b\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005%\u0000"+
		"\u0000\u00d7\u00e3\u0006\f\uffff\uffff\u0000\u00d8\u00d9\u0005\u0012\u0000"+
		"\u0000\u00d9\u00da\u0005$\u0000\u0000\u00da\u00de\u0006\f\uffff\uffff"+
		"\u0000\u00db\u00dd\u0003\u0010\b\u0000\u00dc\u00db\u0001\u0000\u0000\u0000"+
		"\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005%\u0000\u0000\u00e2"+
		"\u00e4\u0006\f\uffff\uffff\u0000\u00e3\u00d8\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0006\f\uffff\uffff\u0000\u00e6\u0019\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0005\u0013\u0000\u0000\u00e8\u00e9\u0005\u001e\u0000\u0000\u00e9"+
		"\u00ea\u0003\"\u0011\u0000\u00ea\u00eb\u0006\r\uffff\uffff\u0000\u00eb"+
		"\u00ec\u0005\u001f\u0000\u0000\u00ec\u00ed\u0005\u0014\u0000\u0000\u00ed"+
		"\u00ee\u0005$\u0000\u0000\u00ee\u00f2\u0006\r\uffff\uffff\u0000\u00ef"+
		"\u00f1\u0003\u0010\b\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005%\u0000\u0000\u00f6\u00f7\u0006"+
		"\r\uffff\uffff\u0000\u00f7\u001b\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005"+
		"\u0015\u0000\u0000\u00f9\u00fa\u0005\'\u0000\u0000\u00fa\u00fb\u0005\""+
		"\u0000\u0000\u00fb\u00fc\u0003&\u0013\u0000\u00fc\u00fd\u0005\u0016\u0000"+
		"\u0000\u00fd\u0100\u0003&\u0013\u0000\u00fe\u00ff\u0005\u0017\u0000\u0000"+
		"\u00ff\u0101\u0003&\u0013\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005\u0014\u0000\u0000\u0103\u0104\u0005$\u0000\u0000\u0104\u0108"+
		"\u0006\u000e\uffff\uffff\u0000\u0105\u0107\u0003\u0010\b\u0000\u0106\u0105"+
		"\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010b"+
		"\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0005%\u0000\u0000\u010c\u010d\u0006\u000e\uffff\uffff\u0000\u010d\u001d"+
		"\u0001\u0000\u0000\u0000\u010e\u0110\u0005\u0018\u0000\u0000\u010f\u0111"+
		"\u0003&\u0013\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110\u0111\u0001"+
		"\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113\u0005"+
		" \u0000\u0000\u0113\u001f\u0001\u0000\u0000\u0000\u0114\u0115\u0005\'"+
		"\u0000\u0000\u0115\u011e\u0005\u001e\u0000\u0000\u0116\u011b\u0003&\u0013"+
		"\u0000\u0117\u0118\u0005#\u0000\u0000\u0118\u011a\u0003&\u0013\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e"+
		"\u0116\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u001f\u0000\u0000\u0121"+
		"\u0122\u0005 \u0000\u0000\u0122!\u0001\u0000\u0000\u0000\u0123\u0128\u0003"+
		"$\u0012\u0000\u0124\u0125\u0007\u0001\u0000\u0000\u0125\u0127\u0003$\u0012"+
		"\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000"+
		"\u0000\u0129#\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000"+
		"\u012b\u012e\u0003&\u0013\u0000\u012c\u012d\u0005&\u0000\u0000\u012d\u012f"+
		"\u0003&\u0013\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f%\u0001\u0000\u0000\u0000\u0130\u0136\u0003(\u0014"+
		"\u0000\u0131\u0132\u0005!\u0000\u0000\u0132\u0133\u0006\u0013\uffff\uffff"+
		"\u0000\u0133\u0135\u0003(\u0014\u0000\u0134\u0131\u0001\u0000\u0000\u0000"+
		"\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000"+
		"\u0136\u0137\u0001\u0000\u0000\u0000\u0137\'\u0001\u0000\u0000\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0139\u013f\u0003*\u0015\u0000\u013a\u013b"+
		"\u0007\u0002\u0000\u0000\u013b\u013c\u0006\u0014\uffff\uffff\u0000\u013c"+
		"\u013e\u0003*\u0015\u0000\u013d\u013a\u0001\u0000\u0000\u0000\u013e\u0141"+
		"\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0001\u0000\u0000\u0000\u0140)\u0001\u0000\u0000\u0000\u0141\u013f\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0005\'\u0000\u0000\u0143\u0152\u0006\u0015"+
		"\uffff\uffff\u0000\u0144\u0145\u0005(\u0000\u0000\u0145\u0152\u0006\u0015"+
		"\uffff\uffff\u0000\u0146\u0147\u0005)\u0000\u0000\u0147\u0152\u0006\u0015"+
		"\uffff\uffff\u0000\u0148\u0149\u0005*\u0000\u0000\u0149\u0152\u0006\u0015"+
		"\uffff\uffff\u0000\u014a\u014b\u0005+\u0000\u0000\u014b\u0152\u0006\u0015"+
		"\uffff\uffff\u0000\u014c\u014d\u0005\u001e\u0000\u0000\u014d\u014e\u0003"+
		"&\u0013\u0000\u014e\u014f\u0005\u001f\u0000\u0000\u014f\u0152\u0001\u0000"+
		"\u0000\u0000\u0150\u0152\u0003,\u0016\u0000\u0151\u0142\u0001\u0000\u0000"+
		"\u0000\u0151\u0144\u0001\u0000\u0000\u0000\u0151\u0146\u0001\u0000\u0000"+
		"\u0000\u0151\u0148\u0001\u0000\u0000\u0000\u0151\u014a\u0001\u0000\u0000"+
		"\u0000\u0151\u014c\u0001\u0000\u0000\u0000\u0151\u0150\u0001\u0000\u0000"+
		"\u0000\u0152+\u0001\u0000\u0000\u0000\u0153\u0154\u0005\'\u0000\u0000"+
		"\u0154\u015d\u0005\u001e\u0000\u0000\u0155\u015a\u0003&\u0013\u0000\u0156"+
		"\u0157\u0005#\u0000\u0000\u0157\u0159\u0003&\u0013\u0000\u0158\u0156\u0001"+
		"\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015e\u0001"+
		"\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d\u0155\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001"+
		"\u0000\u0000\u0000\u015f\u0160\u0005\u001f\u0000\u0000\u0160-\u0001\u0000"+
		"\u0000\u0000\u001e3>LN\\^bpw\u008a\u0099\u009f\u00aa\u00ba\u00d3\u00de"+
		"\u00e3\u00f2\u0100\u0108\u0110\u011b\u011e\u0128\u012e\u0136\u013f\u0151"+
		"\u015a\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}