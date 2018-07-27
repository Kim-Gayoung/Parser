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
	
	private String strToken;
	
	private Token(String strToken) {
		this.strToken = strToken;
	}
	
	public String getStrToken() {
		return strToken;
	}
	
	public static Token findToken(String strToken) throws ParserException {
		for (Token t: Token.values()) {
			if (t.getStrToken().equals(strToken))
				return t;
		}
		throw new ParserException(strToken + " not expected.");
	}
}

