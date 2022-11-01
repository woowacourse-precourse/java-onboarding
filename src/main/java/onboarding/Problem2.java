package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    public static String decrypt(String cryptogram) {
        int length = cryptogram.length();
        List<Character> chars = new ArrayList<>();
        chars.add(cryptogram.charAt(0));

        for (int i = 1; i < length; i++) {
            char current = cryptogram.charAt(i);
            char previous = chars.get(chars.size() - 1);

            if (current == previous) {
                chars.remove(chars.size() - 1);
                continue;
            }

            chars.add(current);
        }

        String answer = toString(chars);

        return answer;
    }

    public static String toString(List<Character> chars) {
        StringBuilder answer = new StringBuilder(chars.size());

        for (Character c : chars) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        return decrypt(cryptogram);
    }
}