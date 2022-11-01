package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> charList = convertStringToCharList(cryptogram);
        return null;
    }

    public static List<Character> convertStringToCharList(String s) {
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        return charList;
    }


}
