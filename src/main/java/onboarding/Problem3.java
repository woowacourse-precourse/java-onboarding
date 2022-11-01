package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalClap = 0;
        for (int i = 1; i <= number; i++) {
            totalClap += countClap(i);
        }
        return totalClap;
    }

    private static int countClap(int number) {
    }


}
