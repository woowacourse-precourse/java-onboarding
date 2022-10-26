package onboarding;

import onboarding.domain.problem3.Clap;

public class Problem3 {
    public static int solution(int number) {
        return countClap(number);
    }

    private static int countClap(int number) {
        int count = 0;
        for (int i = 1; i<= number; i++) {
            count += Clap.clap(i);
        }
        return count;
    }
}
