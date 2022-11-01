package onboarding;

import service.problem3.Problem3ServiceImpl;
import service.problem3.Problem3Serviceable;

public class Problem3 {
    private static final Problem3Serviceable service = new Problem3ServiceImpl();
    public static int solution(int number) {
        return service.getClapCount(number);
    }
}
