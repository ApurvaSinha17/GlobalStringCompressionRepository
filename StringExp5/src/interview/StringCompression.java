package interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringCompression {

	public static void main(String[] args) {
		
		String str = args[0];
		StringCompression strComp = new StringCompression();
		String compressedString = strComp.returnCompressedString(str);
		System.out.println("Compressed String: "+compressedString);
	}
	
	/*******************************************************************************************
	 * This method takes the user entered string and returns either
	 * a new different type of string if there is even one non unique alphabet in that string or
	 * same string if all the characters are unique
	 * Example: String will be modified in the following way
	 * HelloWorld (Input String)
	 * H1e1l3o2W1r1d1 (Output String)
	 * ****************************************************************************************/
	public String returnCompressedString(String str){
		
		char[] strChars = str.toCharArray();
		int strLength = str.length();
		LinkedHashMap charMap = new LinkedHashMap();
		//Key: Unique Alphabet; Value: Occurence of that alphabet in a string
		for(int i=0;i<strLength;i++){
			if(charMap.containsKey(strChars[i])){
				int prevCount = (int) charMap.get(strChars[i]);
				charMap.put(strChars[i], prevCount+1);
			}
			else{
				charMap.put(strChars[i], 1);
			}
		}
		
		Boolean flag = false;
		StringBuilder strBuilder = new StringBuilder();
		Iterator iter = charMap.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> entry = (Entry<Character, Integer>) iter.next();
			char alphabet = entry.getKey();
			strBuilder.append(alphabet);
			int value = entry.getValue();
			strBuilder.append(value);
			if(value>1)
				flag = true;
		}
		
		String compressedString  = strBuilder.toString();
		if(!flag)
			return str;
		else
			return compressedString;
		
	}
	
}
