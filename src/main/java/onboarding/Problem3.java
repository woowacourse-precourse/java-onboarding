package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        int getClap = 0;

        for (int i = 1; i <=number; i++) {
            getClap = i;
            while (getClap > 0) {
                if (getClap % 10 == 3) {
                    count++;
                } else if (getClap % 10 == 6) {
                    count++;
                } else if (getClap % 10 == 9) {
                    count++;
                }
                getClap /= 10;
            }
        }

        return count;
    }
}
