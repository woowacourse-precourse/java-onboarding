package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int n = 1; n <= number; n++) {
            int temp = n;
            while (temp > 0) {
                if (temp%10 == 3 || temp%10 == 6 || temp%10 == 9) {
                    count ++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}
