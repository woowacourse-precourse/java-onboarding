package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int tot = 0;
        for (int i = 3; i <= number; i++) {
            int now = i;

            while (now / 10 > 0) {
                int tmp = now % 10;
                tot = plusTot(tot, tmp);
                now /= 10;
            }
            tot = plusTot(tot, now);
        }
        return tot;
    }

    private static int plusTot(int tot, int tmp) {
        if (tmp == 3 || tmp == 6 || tmp == 9) {
            tot++;
        }
        return tot;
    }
}