package laicode.class7;

public class MissingNumber1 {
	public int missing(int[] array) {
		int res = 0;
		
		for (int i : array) {
			res ^= i;
		}
		for (int i = 1; i <= array.length + 1; i++) {
			res ^= i;
		}
		
		return res;
	}
	
	public static void main (String[] args) {
		MissingNumber1 missingNumber1 = new MissingNumber1();
		int res = missingNumber1.missing(new int[]{2});
		System.out.print(res);
	}
}
