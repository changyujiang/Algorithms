package laicode.class8;

public class ReverseWordsInASentenceI {
	// assumption:
	//
	// method :
	// step1, reverse each word
	// step2, reverse the whole sentence
	public String reverse(String s) {
		// corner case
		if (s == null || s.length() <= 1) {
			return s;
		}

		// step1
		int left = 0;
		int right = 0;
		int cur = 0;
		char[] cArray = s.toCharArray();

		while (cur < cArray.length) {
			if (cArray[cur] != ' ' && (cur == 0 || cArray[cur - 1] == ' ')) {
				left = cur;
			}
			if (cArray[cur] != ' '
					&& (cur == cArray.length - 1 || cArray[cur + 1] == ' ')) {
				right = cur;
				reverse(cArray, left, right);
			}
			cur++;
		}

		// step2
		reverse(cArray, 0, cArray.length - 1);
		return new String(cArray);
	}

	private void reverse(char[] array, int l, int r) {
		while (l < r) {
			swap(array, l, r);
			l++;
			r--;
		}
		return;
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return;
	}

}
