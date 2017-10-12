package laicode.class2;

public class Fibonacci {
	public long fibo(int n) {
		// base case
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return fibo(n - 1) + fibo(n - 2);
	}

	public long fibonacci(int n){
		//
		if (n < 0){
			return 0;
		}

		long[] table = new long[n + 1];
		//base case
		table[0] = 0;
		table[1] = 1;

		for (int i = 2; i <= n; i++){
			table[i] = table[i-1] + table[i-2];
		}

		return table[n];
	}

	public static void main(String[] args) {
		Fibonacci sol = new Fibonacci();
		long res = sol.fibonacci(50);
		System.out.println(res);
	}
}
