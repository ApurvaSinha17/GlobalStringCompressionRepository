package interview;

import static org.junit.Assert.*;

import org.junit.*;

public class StringCompressionTest {

	StringCompression stringCompression = new StringCompression();
	
	@Test
	public void testReturnCompressedString() {
		
		assertNotNull(stringCompression.returnCompressedString("aaabbbccaaabcdba"));
		//Matches the value of two strings
		assertEquals("a7b5c3d1", stringCompression.returnCompressedString("aaabbbccaaabcdba"));	
		//assertEquals("a7b5c3d", stringCompression.returnCompressedString("aaabbbccaaabcdba"));	
				
	}
	
	@Test
	public void testReturnUncompressedString() {
		
		String str = "Apple";
		assertNotNull(stringCompression.returnCompressedString(str));
		//Matches whether the returned string is the same object as the input string
		assertSame(str, stringCompression.returnCompressedString(str));
	}

}
