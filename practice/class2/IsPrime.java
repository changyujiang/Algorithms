package practice.class2;

/**
 * 	Determine whether an integer is a prime 
 *	
 *	Property of prime: the number can be divided exactly only be 1 and the 
 *	number itself.
 */
public class IsPrime {
	//V1
	public boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//V2
	//#iteration = squareRoot(i)
		public boolean isPrimeII(int num) {
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
}
