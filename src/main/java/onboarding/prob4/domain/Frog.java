package onboarding.prob4.domain;

import java.util.HashMap;
import java.util.Map;

public class Frog {

    private static final Map<Character, Character> dict = new HashMap<>();
    static {
        for (int i = 'A'; i <= 'Z'; i++) {
            int i1 = 'Z' - i + 'A';
            char ch = (char) i1;
            dict.put((char) i, ch);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            int i1 = 'a' - i + 'z';
            char ch = (char) i1;
            dict.put((char) i, ch);
        }
    }
    public String solve(String sentence) {
        return say(sentence);
    }

    final String say(String sentence) {
        String ret = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                ret += ' ';
                continue;
            }
             ret += reverse(sentence.charAt(i));
        }
        return ret;
    }
    final Character reverse(char ch) {
        return dict.get(ch);
    }
}
