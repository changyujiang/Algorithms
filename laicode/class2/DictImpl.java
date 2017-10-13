package laicode.class2;

import java.util.Arrays;

public class DictImpl implements Dictionary {
	private int[] array;
	
	public DictImpl(int[] array) {
		this.array = array;
	}
	
	// return null, if index out of bound
	@Override
	public Integer get(int index) {
		if (array == null || index >= array.length){
			return null;
		}
		return array[index];
	}
	
	@Override
	public String toString() {
		if (array == null) {
			return String.valueOf(null);
		}
		if (array.length <= 10) {
			return Arrays.toString(array);
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < 5; i++) {
			sb.append(array[i]).append(", ");
		}
		sb.append("......,");
		for (int i = array.length - 4; i < array.length; i++) {
			sb.append(array[i]);
			if (i != array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
