package laicode.class13dp2;

/*
 * Edit Distance
	Given two strings of alphanumeric characters, determine the minimum number of 
	Replace, Delete, and Insert operations needed to transform one string into the 
	other.

	Assumptions
	Both strings are not null
	
	Examples
	string one: “sigh”, string two : “asith”
	the edit distance between one and two is 2 
	(one insert “a” at front then replace “g” with “t”).\
*/

public class EditDistance {
	  // 0. key point
	  // three operations to transform one string into the other
	  // minimum number of operations
	  
	  // 1. assupmtion
	  // both are not null
	  
	  // 2. approach
	  // DP
	  // m[i][j] represents the minimum number of operations transform first i of s1
	  // into first j of s2
	  //  - initial state: 
	  //    - m[0][0] = 0
	  //    - m[0][j] = j
	  //    - m[i][0] = j
	  //  - induction rule:
	  //    - if s1[i-1] == s2[j-1], m[i][j] = m[i-1][j-1]
	  //    - else, m[i][j] = min(m[i-1][j-1], m[i][j-1], m[i-1][j]) + 1
	  
	  // 3. data structure
	  
	  // 4. commets
	  
	  // 5. BIG O complexity
	  // time: O(m * n) m, s1 length; n, s2 length
	  // space: O(m * n)
	  public int editDistance(String one, String two) {
	    // s1,s2 >= 0
	    int s1 = one.length();
	    int s2 = two.length();
	    
	    int[][] m = new int[s1 + 1][s2 + 1];
	    
	    // space can be reduced to O(n)
	    //int[][] M = new int[2][s2 + 1];

	    // init
	    for (int i = 0; i < s1 + 1; i++) {
	      m[i][0] = i;
	    }
	    for (int j = 0; j < s2 + 1; j++) {
	      m[0][j] = j;
	    }
	    
	    // 
	    for (int i = 1; i < s1 + 1; i++) {
	      for (int j = 1; j < s2 + 1; j++) {
	        if (one.charAt(i-1) == two.charAt(j-1)) {
	          m[i][j] = m[i-1][j-1];
	        } else {
	          m[i][j] = Math.min(m[i-1][j-1], Math.min(m[i-1][j], m[i][j-1])) + 1;
	        }
	      }
	    }
	    return m[s1][s2];
	  }
	}
