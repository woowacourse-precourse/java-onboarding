package onboarding;

import java.util.Map;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
    	String[] strArray = word.split("");
		
		Map<String, String> map = new HashMap<>();
		
		char aAscii = 97;
		char zAscii = 122;
		
		while (aAscii < 122 || zAscii > 97) {
			String fromA = String.valueOf(aAscii);
			String fromZ = String.valueOf(zAscii);
			map.put(fromA, fromZ);
			aAscii++;
			zAscii--;	
		}
		
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

