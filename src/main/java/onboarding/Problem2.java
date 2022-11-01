package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        char[] chars = cryptogram.toCharArray();

        List<String> charList = new LinkedList<>();
        boolean isDuple = true;

        while (isDuple) {
            charList.clear();
            char prev = 0;

            removeRepeat(chars, charList, prev);


        }


        return answer;
    }

    private static void removeRepeat(char[] chars, List<String> charList, char prev) {
        for (int i = 0; i < chars.length; i++) {
            if (prev != chars[i]) {
                charList.add(String.valueOf(chars[i]));
                prev = chars[i];
            } else {
                if (charList.size() >= 1) {
                    charList.remove(charList.size() - 1);
                }
            }
        }
    }

}