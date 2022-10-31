package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
		
		String[] strArray = cryptogram.split("");
		
		List<String> list = new ArrayList<>(Arrays.asList(strArray));
		
		int pointer = 0;
		 
		while (pointer < list.size()-1) {
			if (list.get(pointer).equals(list.get(pointer+1))) {
				list.remove(pointer);
				list.remove(pointer);
				pointer -= 1;
				
			}else {
				pointer += 1;
			}
		}
		
		String answer = list.toString().replaceAll("[^a-z0-9]", "");
		
		return answer;
       
    }
}
