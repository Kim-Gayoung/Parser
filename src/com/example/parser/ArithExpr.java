package com.example.parser;

public class ArithExpr extends Expr {
	private int op;
	private Expr oprnd1, oprnd2;
	
	public static final int PLUS = 1;
	public static final int MULTIFLY = 3;
	
	public ArithExpr(Expr oprnd1, int op, Expr oprnd2) {
		super();
		this.op = op;
		this.oprnd1 = oprnd1;
		this.oprnd2 = oprnd2;
	}

	public int getOp() {
		return op;
	}
	
	public void setOp(int op) {
		this.op = op;
	}
	
	public Expr getOprnd1() {
		return oprnd1;
	}
	
	public void setOprnd1(Expr oprnd1) {
		this.oprnd1 = oprnd1;
	}
	
	public Expr getOprnd2() {
		return oprnd2;
	}
	
	public void setOprnd2(Expr oprnd2) {
		this.oprnd2 = oprnd2;
	}
	
}
