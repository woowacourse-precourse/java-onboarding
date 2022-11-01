package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    private static int count369(int number) {
        int count = 0;

        while (number != 0) {
            int tmp = number % 10;

            if (tmp == 3 || tmp == 6 || tmp == 9) {
                count++;
            }

            number /= 10;
        }

        return  count;
    }
}
