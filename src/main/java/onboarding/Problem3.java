package onboarding;

import problem3.Game369ClapCounter;

public class Problem3 {

    public static final int ERROR_CODE = -1;

    public static int solution(int number) {
        try {
            return Game369ClapCounter.countFromOneTo(number);
        } catch (RuntimeException e) {
            return ERROR_CODE;
        }
    }
}
