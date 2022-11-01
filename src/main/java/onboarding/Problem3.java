package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = start(number);
        return answer;
    }

    private static int start(int number) {
        int answer = 0;
        for (int i = 1; i <= number; ++i) {
            answer += isContain369(i);
        }
        return answer;
    }

    public static int isContain369(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            if ((digit == 3) || (digit == 6) || (digit == 9)) {
                count++;
            }
        }
        return count;
    }
}
