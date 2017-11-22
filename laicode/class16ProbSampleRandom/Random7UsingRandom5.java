package laicode.class16ProbSampleRandom;

import laicode.common.RandomFive;

/*
 * Random7 Using Random5
Given a random generator random5(), 
the return value of random5() 
is 0 - 4 with equal probability. 
Use random5() to implement random7().*/

public class Random7UsingRandom5 {
	  // 0. key point
	  // given random5, implemnt random7
	  
	  // 1. assumption
	  
	  // 2. approach
	  // generate two digits using random5 to construct a number with base5 [0-4][0-4], say ab
	  // then the corresponding decimal number is 5*a + b 0 ~ 24;
	  // we get a random25 with random5
	  // Then use the property of Conditional probability
	  // we get rid of result larger than 20
	  // then we get a random21 from random25
	  // in the end we random21 % 7 to get a random7
	  
	  // 3. data structue
	  
	  // 4. comment
	  
	  // 5. Big O complexity
	  // time: 
	  // space:
	  public int random7() {
	    // you can use RandomFive.random5() for generating
	    // 0 - 4 with equal probability.
	    while(true) {
	      int a = RandomFive.random5();
	      int b = RandomFive.random5();
	      int random25 = 5 * a + b;
	      if (random25 < 21) {
	        return random25 % 7;
	      } 
	    }
	  }
}
