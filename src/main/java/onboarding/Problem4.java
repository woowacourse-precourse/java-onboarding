package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] alphabetArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Map<Character, Character> reverseMap = new HashMap();
        for(int i=0; i<alphabetArr.length; i++) {
            reverseMap.put(alphabetArr[i], alphabetArr[alphabetArr.length-1-i]);
        }

        return answer;
    }
}
