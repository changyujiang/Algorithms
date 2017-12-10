package laicode.class10.recursion2;

/*String Abbreviation Matching
 Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an 
 abbreviation, return if the string matches the abbreviation.

 Assumptions:
 The original string only contains alphabetic characters.
 Both input and pattern are not null.

 Examples:
 pattern “s11d” matches input “sophisticated” since “11” matches eleven 
 chars “ophisticate”.*/

public class StringAbbreviationMatching {
	// 0. key point
	// match a string and abbreviation
	// return a boolean

	// 1. assumption
	// string only contains alphabetic characters
	// both are not null
	// length >= 0

	// 2. approach
	// recursion
	// case1: pattern.charAt(i) == 'a-zA-Z', check with input.charAt(j)
	// case2: pattern.charAt(i) == '0-9', read the number and move pointers on
	// input

	// 3. data structure

	// 4. comment

	// 5. big o complexity
	// Time: O(n)
	// Space: O(m)
	public boolean match(String input, String pattern) {
		// assumption: not null
		// corner case
		if (input.length() == 0 || pattern.length() == 0) {
			return input.length() == 0 && pattern.length() == 0 ? true : false;
		}

		// pointers for each string
		int p0 = 0;
		int p1 = 0;
		return match(input, pattern, p0, p1);
	}

	private boolean match(String input, String pattern, int i, int j) {
		// base case
		if (i == input.length() && j == pattern.length()) {
			return true;
		}
		if (i >= input.length() || j >= pattern.length()) {
			return false;
		}

		// case 1
		// not a digit
		if (pattern.charAt(j) > '9' || pattern.charAt(j) < '0') {
			if (pattern.charAt(j) == input.charAt(i)) {
				return match(input, pattern, i + 1, j + 1);
			}
			return false;
		}

		// case2
		int num = 0;
		while (j < pattern.length() && pattern.charAt(j) <= '9'
				&& pattern.charAt(j) >= '0') {
			num = num * 10 + pattern.charAt(j) - '0';
			j++;
		}
		return match(input, pattern, i + num, j);
	}
}
