package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import javax.sound.sampled.ReverbType;

import one.Looping;

import org.junit.Ignore;
import org.junit.Test;

import edu.berkeley.eduride.EduRideTest.*;


@Description("Tests on Looping.java")
public class TestsOnLooping {

	private static void realRevIP(int[] data) {
	    int left = 0;
	    int right = data.length - 1;

	    while( left < right ) {
	        // swap the values at the left and right indices
	        int temp = data[left];
	        data[left] = data[right];
	        data[right] = temp;

	        // move the left and right index pointers in toward the center
	        left++;
	        right--;
	    }
	}
	
	private static int[] realRev(int[] in) {
		int[] out = Arrays.copyOf(in, in.length);
		realRevIP(out);
		return out;
	}
	
	
	// it'd be better not to repeat values, eh
	private static int[] randomArr(int len) {
		int[] out = new int[len];
		Random r = new Random();
		for (int i=0; i<len; i++) {
			out[i] = r.nextInt(Integer.MAX_VALUE);
		}
		return out;
	}
	
	
	
	//////// small array
	
	@Test
	@Name("Small array in reverseInPlace")
	public void ripSmall() {
		try {
			int[] in = randomArr(5);
			int[] exp = realRev(in);
			Looping.reverseInPlace(in);
			assertArrayEquals("reverseInPlace failed on a small array",
					exp, in);
		} catch (Exception e) {
			fail("reverseInPlace caused error on a small array");
		}
	}
	
	
	@Test
	@Name("Small array in reverseCopy")
	public void rcSmall() {
		try {
			int[] in = randomArr(5);
			int[] in_copy = Arrays.copyOf(in, in.length);
			int[] exp = realRev(in);
			int[] obs = Looping.reverseCopy(in);
			assertArrayEquals("reverseCopy failed on a small array",
					exp, obs);
			assertArrayEquals("reverseCopy changed the input array!", in, in_copy);
		} catch (Exception e) {
			fail("reverseInPlace caused error on a small array");
		}
	}
	
	
	/// big arrays
	
	@Test
	@Name("Small array in reverseInPlace")
	public void ripBig() {
		try {
			int[] in = randomArr(100);
			int[] exp = realRev(in);
			Looping.reverseInPlace(in);
			assertArrayEquals("reverseInPlace failed on a small array",
					exp, in);
		} catch (Exception e) {
			fail("reverseInPlace caused error on a small array");
		}
	}
	
	
	@Test
	@Name("Small array in reverseCopy")
	public void rcBig() {
		try {
			int[] in = randomArr(100);
			int[] in_copy = Arrays.copyOf(in, in.length);
			int[] exp = realRev(in);
			int[] obs = Looping.reverseCopy(in);
			assertArrayEquals("reverseCopy failed on a small array",
					exp, obs);
			assertArrayEquals("reverseCopy changed the input array!", in, in_copy);
		} catch (Exception e) {
			fail("reverseInPlace caused error on a small array");
		}
	}

	// empty arrays
	
	@Test
	@Name("In-place reverse on empty array")
	public void ripEmpty() {
		try {
			int[] in = new int[0]; 
			Looping.reverseInPlace(in);
			assertEquals("Passed in empty array, array now not empty", 0, in.length);
		} catch (Exception e) {
			fail("reverseInPlace caused error on empty array");
		}
	}

	
	
	@Test
	@Name("reverse on empty array")
	public void rcEmpty() {
		try {
			int[] in = new int[0]; 
			int[] out = Looping.reverseCopy(in);
			assertEquals("Passed in empty array, returned array not empty", 0, out.length);
		} catch (Exception e) {
			fail("reverseCopy caused error on empty array");
		}
	}
	
}
