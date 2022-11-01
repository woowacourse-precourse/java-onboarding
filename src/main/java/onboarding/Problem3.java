package onboarding;

public class Problem3 {
    public static int getCnt(int num) {
        int cnt = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int[] arr = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            arr[i] = arr[i - 1] + getCnt(i);
        }

        return arr[number];
    }
}
