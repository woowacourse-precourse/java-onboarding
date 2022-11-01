package onboarding;

import onboarding.problem4.ReverseTranslator;

public class Problem4 {
    public static String solution(String word) {
        if(word == null){
            throw new IllegalArgumentException("올바르지 않은 매개변수: null");
        }

        if(word.length() < 1 || word.length() > 1000){
            throw new IllegalArgumentException("유효하지 않은 범위");
        }

        ReverseTranslator reverseTranslator = new ReverseTranslator();

        return reverseTranslator.generate(word);
    }
}
