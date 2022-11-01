package onboarding;

public class Problem3 {
    public static int clab(int num) {
        int count = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit % 3 == 0 && digit != 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int total = 0;

        for (int i = 1; i <= number; i++) {
            total += clab(i);
        }
        return total;
    }
}
