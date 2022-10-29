package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character,Character> wordMap = new HashMap<Character, Character>();

        char upperA = 'A';
        char lowerA = 'a';

        for (int i=0; i<13; i++){
            wordMap.put((char) (upperA+i), (char) (upperA+25-i));
            wordMap.put((char) (lowerA+i), (char) (lowerA+25-i));
        }

        return "";
    }
}
