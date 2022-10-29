package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
    	String[] strArray = word.split("");
		
		Map<String, String> map = new HashMap<>();
		
		map.put("a", "z");
		map.put("b", "y");
		map.put("c", "x");
		map.put("d", "w");
		map.put("e", "v");
		map.put("f", "u");
		map.put("g", "t");
		map.put("h", "s");
		map.put("i", "r");
		map.put("j", "q");
		map.put("k", "p");
		map.put("l", "o");
		map.put("m", "n");
		map.put("n", "m");
		map.put("o", "l");
		map.put("p", "k");
		map.put("q", "j");
		map.put("r", "i");
		map.put("s", "h");
		map.put("t", "g");
		map.put("u", "f");
		map.put("v", "e");
		map.put("w", "d");
		map.put("x", "c");
		map.put("y", "b");
		map.put("z", "a");
		
		
		for (int i=0; i<strArray.length; i++) {
			if (strArray[i].equals(" ")) {
				continue;
			}
			
			if (strArray[i].equals(strArray[i].toLowerCase())) {
				strArray[i] = map.get(strArray[i]);
				
			}else {
				strArray[i] = map.get(strArray[i].toLowerCase()).toUpperCase();
			}
		
		}
		
		String answer = String.join("", strArray);
		
		
		return answer;
    }
}

