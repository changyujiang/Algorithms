package laicode.test;

import java.io.*;

public class Test {
	static void fun() {
		try{
			throw new NullPointerException("aa");
		} catch (IllegalArgumentException e) {
			System.out.println("caught in fun");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			fun();
		} catch (NullPointerException e) {
			System.out.println("caught in main");
			
		}
	}
}
