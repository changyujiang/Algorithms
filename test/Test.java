package test;

import java.io.UnsupportedEncodingException;

public class Test {
	String s = new String("ff");
	StringBuilder sb = new StringBuilder("a");
	StringBuffer sb1 = new StringBuffer("a");
	
	public static void main(String[] args) {
		/*String s1 = "Programming";
	    String s2 = new String("Programming");
	    String s3 = "Program";
	    String s4 = "ming";
	    String s5 = "Program" + "ming";
	    String s6 = s3 + s4;
	    System.out.println(s1 == s2);
	    System.out.println(s1 == s5);
	    System.out.println(s1 == s6);
	    System.out.println(s1 == s6.intern());
	    System.out.println(s2 == s2.intern());*/
	    
	    /*String s1 = new StringBuilder("go")
	    .append("od").toString();
	    System.out.println(s1.intern() == s1);
	    String s2 = new StringBuilder("ja")
	    .append("va").toString();
	    System.out.println(s2.intern() == s2);*/
		
		A a = new A();
		a = new B();
		a = new B();
		// 12a2b2b
		
		String s1 = "你好";
		String s2 = "";
		try {
			s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s1);
		System.out.println(s2);
		
		assert(1 > 2);
		
		System.out.println(s2);
		
		Object aa = new Object();
	}
	
	
}
