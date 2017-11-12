package practice.class2;

/**
 * Calculate the greatest common divisor of two integers
 * Method: successive subtraction 
 */
public class GreatestCommonDivisor {
	public int gcd(int a, int b) {
		while (a != b) {
			if (a < b) {
				b = b - a;
			} else {
				a = a - b;
			}
		}
		return a;
	}
}
