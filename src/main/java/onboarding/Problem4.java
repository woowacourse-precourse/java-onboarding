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

        for(int i=0; i<word.length(); i++) {
            char charWord = word.charAt(i);
            if(word.charAt(i) == ' ') {
                answer += " ";
            } else {
                String reverseWord = String.valueOf(reverseMap.get(word.toLowerCase().charAt(i)));
                if(Character.isUpperCase(word.charAt(i))) {
                    answer += reverseWord.toUpperCase();
                } else {
                    answer += reverseWord;
                }
            }
        }

        return answer;
    }
}
