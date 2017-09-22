package leetcode;

/**
 *
 * @author Changyu
 * 
 */

/*
	678. Valid Parenthesis String
	Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
	Example 1:
	Input: "()"
	Output: True
	Example 2:
	Input: "(*)"
	Output: True
	Example 3:
	Input: "(*))"
	Output: True
	Note:
	The string size will be in the range [1, 100].
 */

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
        return checkFromLeft(s) && checkFromRight(s);
    }
    
    public boolean checkFromLeft(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        
        int left = 0;
        int right = 0;
        int star = 0;
        
        for (char a : s.toCharArray()){
            if (a == '(') left++;
            else if (a == ')') right++;
            else if (a == '*') star++;
            if (right > left + star) return false;
        }
        
        return true;
    }
    
    public boolean checkFromRight(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        
        int left = 0;
        int right = 0;
        int star = 0;
        
        for (int i = s.length()-1; i >=0; i--){
            char a = s.charAt(i);
            if (a == '(') left++;
            else if (a == ')') right++;
            else if (a == '*') star++;
            if (left > right + star) return false;
        }
        
        return true;
    }
}
