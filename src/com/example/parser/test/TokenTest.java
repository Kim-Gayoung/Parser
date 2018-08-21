package com.example.parser.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.lib.ParserException;
import com.example.parser.Token;

class TokenTest {

	@Test
	void test() {
		try {
			Token cParen = Token.CLOSEPAREN;
			Token plus = Token.PLUS;
			Token end = Token.END_OF_TOKEN;
			
			String plusStr = plus.getStrToken();

			assertTrue(Token.findToken(")") == cParen);
			assertTrue(Token.findToken("+") == plus);
			assertTrue(Token.findToken("$") == end);
		}
		catch (ParserException e) {
		}
	}

}
