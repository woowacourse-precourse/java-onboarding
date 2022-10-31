package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int n = 0;

        for (int num = 1; num <= number; num++) {
            n = num;
            while (true) {
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
                    answer += 1;
                if (n < 10)
                    break;
                n = n / 10;
            }
        }
        return answer;
    }
}
