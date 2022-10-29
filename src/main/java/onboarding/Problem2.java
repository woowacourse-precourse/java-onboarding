package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return answer;
    }

    private static String decrypt(String cryptogram) {
        List<Character> charList = new LinkedList<>();

        splitString(cryptogram, charList);

        return cryptogram;
    }

    private static List<Character> splitString(String cryptogram, List<Character> charList) {
        char[] chars = cryptogram.toCharArray();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }
}
