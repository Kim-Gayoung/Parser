package com.example.parser.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import com.example.lib.LexerException;
import com.example.lib.ParserException;
import com.example.parser.ArithExpr;
import com.example.parser.Expr;
import com.example.parser.NumValue;
import com.example.parser.Parser;

class ParserTest {
	@Test
	void test1() throws IOException, LexerException, ParserException {
		StringReader sr = new StringReader("123");
		Parser parser = new Parser();
		
		Expr e = parser.Parsing(sr);
		
		assertTrue(e instanceof NumValue);
	}

	@Test
	void test2() throws IOException, LexerException, ParserException {
		StringReader sr = new StringReader("123 +  xyz34 * (456 + abc5)");
		Parser parser = new Parser();
		
		Expr e = parser.Parsing(sr);
		
		assertTrue(e instanceof ArithExpr && ((ArithExpr) e).getOp() == ArithExpr.PLUS);
	}

}
