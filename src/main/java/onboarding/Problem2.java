package onboarding;

import service.problem2.Problem2ServiceImpl;
import service.problem2.Problem2Serviceable;

public class Problem2 {
    private static final Problem2Serviceable service = new Problem2ServiceImpl();

    public static String solution(String cryptogram) {
        return service.getCryptogram(cryptogram);
    }
}
