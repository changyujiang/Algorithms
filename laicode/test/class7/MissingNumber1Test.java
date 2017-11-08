package laicode.test.class7;

import static org.junit.Assert.*;
import laicode.class7.MissingNumber1;

import org.junit.Test;

public class MissingNumber1Test {

	@Test
	public void test() {
		assertEquals(1, new MissingNumber1().missing(new int[]{2}));
	}

}
