package onboarding;

import problem4.SentenceTranslator;

public class Problem4 {
    public static String solution(String word) {
        SentenceTranslator translator = new SentenceTranslator();
        return translator.translate(word);
    }
}
