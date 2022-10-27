package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static Stack<Character> deduplication(String cryptogram) {
        Stack<Character> characters = new Stack<>();
        char[] chars = cryptogram.toCharArray();

        char before = chars[0];
        characters.push(before);

        for (int i = 1; i < cryptogram.length(); i++) {
            char now = chars[i];
            if (before == now) {
                characters.pop();
            } else {
                characters.push(now);
            }

            before = now;
        }
        
        return characters;
    }
}
