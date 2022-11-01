package onboarding;

import onboarding.problem4.Word;

public class Problem4 {
    public static String solution(String word) {
        Word w = new Word(word);
        return w.convert();
    }
}
