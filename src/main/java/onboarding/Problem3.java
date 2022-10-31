package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int total = 0;

        for (int i = 1; i <= number; i++) {
            int temp = i;
            while (temp > 1) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
                    total++;
                }
                temp /= 10;
            }
        }

        return total;
    }
}
