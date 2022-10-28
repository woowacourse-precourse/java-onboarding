package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
		
        String answer = "";

        char[] char_arr = cryptogram.toCharArray();
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i < char_arr.length; i++) {
        	arr.add(char_arr[i]);
        }

        int idx = 0;
        while(arr.size() != 0) {
        	if(arr.get(idx) == arr.get(idx+1)) {
        		arr.remove(idx);
        		arr.remove(idx);
        		idx = 0;
        	} else {
        		idx++;
        		if(idx == arr.size() - 1) break;
        	}
        }

        for(int i = 0; i < arr.size(); i++) {
        	answer += arr.get(i);
        }

        return answer;
    }
}