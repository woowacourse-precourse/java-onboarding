package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> charList = new ArrayList<>();
        splitWord(word, charList);
        return answer;
    }

    private static List<Character> splitWord(String word, List<Character> charList) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }
}
