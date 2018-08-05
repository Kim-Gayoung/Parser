package com.example.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	private ArrayList<Terminal> lexer;
	
	private CommonParserUtil pu;

	public Parser(LexicalAnalyzer lexicalAnalyzer) throws IOException, LexerException {
		lexer = lexicalAnalyzer.Lexing();
		
		pu = new CommonParserUtil(lexer);
		
		pu.rule("E' -> E", () -> { return pu.get(1); });
		pu.rule("E -> E + T", () -> {
			return new ArithExpr((Expr) pu.get(1), ArithExpr.PLUS, (Expr) pu.get(3));
		});
		pu.rule("E -> T", () -> { return pu.get(1); });
		pu.rule("T -> T * F", () -> {
			return  new ArithExpr((Expr) pu.get(1), ArithExpr.MULTIFLY, (Expr) pu.get(3));
		});
		pu.rule("T -> F", () -> { return pu.get(1); });
		pu.rule("F -> ( E )", () -> { return pu.get(2); });
		pu.rule("F -> id", () -> { return new Identifier(pu.getText(1)); });
		pu.rule("F -> num", () -> { return new NumValue(Double.parseDouble(pu.getText(1))); });
	}
	
	public Expr Parsing() throws FileNotFoundException, ParserException {
		return (Expr) pu.Parsing();
	}
	
}
