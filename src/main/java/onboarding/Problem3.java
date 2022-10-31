package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;

        for (int i = 1; i <= number; i++) {
            cnt += getNumberCount(i);
        }
        return cnt;
    }

    private static int getNumberCount(int number) {
        int cnt = 0;
        while (number > 0) {
            int checkNum = number % 10;
            if (checkNum == 3 || checkNum == 6 || checkNum == 9) {
                cnt++;
            }
            number /= 10;
        }

        return cnt;
    }

}
