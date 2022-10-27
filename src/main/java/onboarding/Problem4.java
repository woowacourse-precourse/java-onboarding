package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
// 1. 배열에 청개구리 사전 저장
        ArrayList<Character> upperDictionary = new ArrayList<>();
        ArrayList<Character> lowerDictionary = new ArrayList<>();


        for (int i = 0; i < 26; i++) {
            upperDictionary.add((char) ('Z'-i));
            lowerDictionary.add((char) ('z' - i));
        }

        // 2. 주어진 word 청개구리 사전에 맞춰서 변환
        for (int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i)))
                answer += upperDictionary.get((int)(word.charAt(i)-'A'));
            else if(Character.isLowerCase(word.charAt(i)))
                answer+=lowerDictionary.get((int)(word.charAt(i)-'a'));
            else answer+=' ';
        }


        return answer;
    }
}
