package onboarding;

import problem3.Counter369;

import java.util.function.IntFunction;

public class Problem3 {
    public static int solution(int number) {
        Counter369 counter = new Counter369();

        for (int i = 1; i <= number; i++) {
            counter.count369(i);
        }

        return counter.getTotalCount();
    }


}
