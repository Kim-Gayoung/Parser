package com.example.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.example.lib.CommonParserUtil;
import com.example.lib.LexerException;
import com.example.lib.ParserException;
import com.example.lib.Terminal;

public class Parser {
	private ArrayList<Terminal> lexer;
	
	private CommonParserUtil pu;

	public Parser() throws IOException, LexerException {
		pu = new CommonParserUtil();
		
		pu.lex("[ \t\n]", text -> { return null; });
		pu.lex("[0-9]*", text -> { return Token.NUM; });
		pu.lex("[a-zA-Z]+[0-9]*", text -> { return Token.ID; });
		pu.lex("\\(", text -> { return Token.OPENPAREN; });
		pu.lex("\\)", text -> { return Token.CLOSEPAREN; });
		pu.lex("\\+", text -> { return Token.PLUS; });
		pu.lex("\\*", text -> { return Token.MULTIPLY; });
		pu.lexEndToken("$", text -> { return Token.END_OF_TOKEN; });
		
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
	
	public Expr Parsing(Reader r) throws ParserException, IOException, LexerException {
		return (Expr) pu.Parsing(r);
	}
	
}
