package onboarding;

public class Problem3 {
    public static final int NO_CLAP = 0;

    public static int solution(int number) {;
        return calculateClapCount(number);
    }

    private static int calculateClapCount(int number) {
        int clapCount = NO_CLAP;
        for (int i = 1; i <= number; i++) {
            clapCount += find369(i);
        }
        return clapCount;
    }

    private static int find369(int number) {
        return 0;
    }
}
