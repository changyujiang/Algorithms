package practice.class19;

public class Convert {
	// hex: a 10 b 11 c 12 d 13 e 14 f 15 
	// A 10
	public int HexCharToInt (char a) {
		if (a <= '9' && a >= '0') {
			return a -'0';
		} else if (a <= 'F' && a >= 'A' ) {
			return a - 'A' + 10;
		} else if (a <= 'f' && a >= 'a') {
			return a - 'a' + 10;
		}
		return -1;
	}
}
