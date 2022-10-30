package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (outOfRange(number)) return -1;

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int num = i;

            while (num > 0) {
                int n = num % 10;
                if (n == 3 || n == 6 || n == 9) {
                    answer++;
                }

                num /= 10;
            }
        }

        return answer;
    }
    
    static boolean outOfRange(int number) {
        return number < 1 || number > 10000;
    }
}
