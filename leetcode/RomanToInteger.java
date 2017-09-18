package leetcode;

/*
 	Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
	
	I 1; V 5; X 10; L 50; C 100; D 500; M 1000
	Only I,X,C can be used to subtract from a right-hand roman.
	MMMCCCXXXIII 3333
 */

public class RomanToInteger {
	public int romantoInt(String s){
		if (s == null || s.length() == 0){
			throw new IllegalArgumentException("illegal input");
		}
		
		int[] result = new int[s.length()];
		int sum = 0;
		
		for(int i = 0; i < s.length(); i++){
			switch (s.charAt(i)) {
			case 'I':
				result[i] = 1;
				break;
			case 'V':
				result[i] = 5;
				break;
			case 'X':
				result[i] = 10;
				break;
			case 'L':
				result[i] = 50;
				break;
			case 'C':
				result[i] = 100;
				break;
			case 'D':
				result[i] = 500;
				break;
			case 'M':
				result[i] = 1000;
				break;
			}
		}
		for(int i = 0; i < result.length-1; i++){
			if (result[i]<result[i+1]) sum -= result[i];
			else sum += result[i];
		}
		sum += result[result.length];
		
		return sum;
	}
}
