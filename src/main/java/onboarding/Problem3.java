package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getClapNum(number);
    }

    private static int getClapNum(int number) {
        int count = 0;
        int tmp;

        for (int i = 1; i <= number; i++) {
            tmp = i;
            while(tmp > 0) {
                if (tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9) {
                    count++;
                }
                tmp = tmp / 10;
            }
        }
        return count;
    }
}
