// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package br.edu.cefsa.compiler.parser;

	import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyLanguageParser}.
 */
public interface EasyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(EasyLanguageParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(EasyLanguageParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(EasyLanguageParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(EasyLanguageParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declaraconst}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraconst(EasyLanguageParser.DeclaraconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declaraconst}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraconst(EasyLanguageParser.DeclaraconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declarafuncao}.
	 * @param ctx the parse tree
	 */
	void enterDeclarafuncao(EasyLanguageParser.DeclarafuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declarafuncao}.
	 * @param ctx the parse tree
	 */
	void exitDeclarafuncao(EasyLanguageParser.DeclarafuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(EasyLanguageParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(EasyLanguageParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(EasyLanguageParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(EasyLanguageParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(EasyLanguageParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(EasyLanguageParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(EasyLanguageParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(EasyLanguageParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(EasyLanguageParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(EasyLanguageParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepeticao(EasyLanguageParser.CmdrepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepeticao(EasyLanguageParser.CmdrepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdfor}.
	 * @param ctx the parse tree
	 */
	void enterCmdfor(EasyLanguageParser.CmdforContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdfor}.
	 * @param ctx the parse tree
	 */
	void exitCmdfor(EasyLanguageParser.CmdforContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdretorno}.
	 * @param ctx the parse tree
	 */
	void enterCmdretorno(EasyLanguageParser.CmdretornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdretorno}.
	 * @param ctx the parse tree
	 */
	void exitCmdretorno(EasyLanguageParser.CmdretornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdchamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdchamada(EasyLanguageParser.CmdchamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdchamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdchamada(EasyLanguageParser.CmdchamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expr_logica}.
	 * @param ctx the parse tree
	 */
	void enterExpr_logica(EasyLanguageParser.Expr_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expr_logica}.
	 * @param ctx the parse tree
	 */
	void exitExpr_logica(EasyLanguageParser.Expr_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expr_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExpr_relacional(EasyLanguageParser.Expr_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expr_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExpr_relacional(EasyLanguageParser.Expr_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(EasyLanguageParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(EasyLanguageParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#chamada_funcao}.
	 * @param ctx the parse tree
	 */
	void enterChamada_funcao(EasyLanguageParser.Chamada_funcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#chamada_funcao}.
	 * @param ctx the parse tree
	 */
	void exitChamada_funcao(EasyLanguageParser.Chamada_funcaoContext ctx);
}