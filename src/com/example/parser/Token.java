package com.example.parser;

import java.util.HashMap;

public enum Token {
//	ENDOFTOKEN,
//	OPENPAREN, CLOSEPAREN,
//	PLUS, MULTIPLY,
//	NUM, ID	
	ENDOFTOKEN("$"),
	OPENPAREN("("), CLOSEPAREN(")"),
	PLUS("+"), MULTIPLY("*"),
	NUM("num"), ID("id");
	
	private String syntax;
	
	private Token(String syntax) {
		this.syntax = syntax;
	}
	
	public String getSyntax() {
		return syntax;
	}
	
	public static Token findToken(String strToken) throws ParserException {
		for (Token t: Token.values()) {
			if (t.getSyntax().equals(strToken))
				return t;
		}
		throw new ParserException(strToken + " not expected.");
	}
}

