package onboarding;

import problem3.Game369ClapCounter;

public class Problem3 {
    public static int solution(int number) {
        try {
            return Game369ClapCounter.countFromOneTo(number);
        } catch (RuntimeException e) {
            return -1;
        }
    }
}
