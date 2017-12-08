package laicode.class13dp2;

import java.util.HashSet;
import java.util.Set;

/*Dictionary Word I
Given a word and a dictionary, determine if it can be composed by 
concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and 
all the words in the dictionary are not null or empty

Examples
Dictionary: {“bob”, “cat”, “rob”}
Word: “robob” return false
Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"*/

public class DictionaryWordI {
	// 0. key point
	// word & dictionary

	// 1. assumption
	// word is not null not empty
	// dictionary not null not empty

	// 2. approach
	// DP
	// cb[i] represents if input[0..i-1] can break
	// i can be viewed as the substring length
	// initial state cb[0] = true
	// induction rule
	// dp[i] = dp[0] && dict.contains.substring(0..i) || dp[1] &&
	// dict.contains.substring(1..i) ||
	// ... dp[i-1] && dict.contains.substring(i-1.. i)

	// 3. data structure
	// use a hashSet to store words in dictionary to improve the search
	// operation.

	// 4. comments

	// 5. BIG O complexity
	// time: O(n^2)
	// space: O(n)
	public boolean canBreak(String input, String[] dict) {

		boolean[] cb = new boolean[input.length() + 1];

		Set<String> dictSet = new HashSet<>();
		for (String s : dict) {
			dictSet.add(s);
		}

		// initial length == 0
		cb[0] = true;

		// 01234
		// robob
		// i = 5 length
		// j = 0
		// |robob substring(0,5) (j,i)
		// string.substring(startIndex, endIndex) [startIndex, endIndex)

		for (int i = 1; i <= input.length(); i++) {
			boolean curRes = false;
			for (int j = 0; j < i; j++) {
				if (cb[j] && dictSet.contains(input.substring(j, i))) {
					curRes = true;
				}
			}
			cb[i] = curRes;
		}
		return cb[input.length()];
	}
}
