package practice.class2;

/**
 * Calculate fibonacci number from bottom-up
 *
 */
public class Fibonacci {
	public long fibo (int index) {
		int f1 = 0;
		int f2 = 1;
		long p1 = f1;
		long p2 = f2;
		// corner cases
		if (index == 1) {
			return f1;
		} else if (index == 2) {
			return f2;
		} else if (index <= 0) {
			return -1;
		}
		for (int i = 3; i <= index; i++) {
			long tmp = p2;
			p2 = p1 + p2;
			p1 = tmp;
		}
		return p2;
	}
}
