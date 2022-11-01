package onboarding;

public class Problem3 {
    static int clapCount;
    public static int solution(int number) {
        clapCount = 0;

        for(int i = 1; i <= number; i++) {
            countClap(i);
        }

        return clapCount;
    }

    private static void countClap(int number) {
        while(number > 0) {
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                clapCount++;
            }
            number /= 10;
        }
    }
}