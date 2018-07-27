package com.example.parser.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import com.example.parser.ArithExpr;
import com.example.parser.Expr;
import com.example.parser.LexerException;
import com.example.parser.LexicalAnalyzer;
import com.example.parser.NumValue;
import com.example.parser.Parser;
import com.example.parser.ParserException;

class ParserTest {
	@Test
	void test1() throws IOException, LexerException, ParserException {
		StringReader sr = new StringReader("123");
		LexicalAnalyzer lexical = new LexicalAnalyzer(sr);
		Parser parser = new Parser(lexical);
		
		Expr e = parser.Parsing();
		
		assertTrue(e instanceof NumValue);
	}

	@Test
	void test2() throws IOException, LexerException, ParserException {
		StringReader sr = new StringReader("123 +  xyz34 * (456 + abc5)");
		LexicalAnalyzer lexical = new LexicalAnalyzer(sr);
		Parser parser = new Parser(lexical);
		
		Expr e = parser.Parsing();
		
		assertTrue(e instanceof ArithExpr && ((ArithExpr) e).getOp() == ArithExpr.PLUS);
	}

}
