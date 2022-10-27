package onboarding;

import java.util.HashMap;
import java.util.HashSet;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character,Character> dictonary = new HashMap<>();
        char[] chars = word.toCharArray();

        int currentUpperValue = 'Z';
        for(int ascii = 'A'; ascii <= 'Z'; ascii++) {
            dictonary.put((char) ascii, (char) currentUpperValue);
            currentUpperValue--;
        }

        int currentLowerValue = 'z';
        for(int ascii = 'a'; ascii <= 'z'; ascii++){
            dictonary.put((char)ascii,(char)currentLowerValue);
            currentLowerValue--;
        }

        for(int index=0; index < chars.length; index++) {
            if(dictonary.containsKey(chars[index]) == true){
                answer = answer + dictonary.get(chars[index]);
            }
            if(dictonary.containsKey(chars[index]) == false){
                answer = answer + chars[index];
            }
        }

        return answer;
    }
}
