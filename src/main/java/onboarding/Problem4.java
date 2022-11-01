package onboarding;

import service.problem4.Problem4ServiceImpl;
import service.problem4.Problem4Serviceable;

public class Problem4 {
    private static final Problem4Serviceable service = new Problem4ServiceImpl();

    public static String solution(String word) {
        return service.getConvertSentence(word);
    }
}

