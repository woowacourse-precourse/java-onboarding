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
            int remainder = number % 10;
            if (remainder == 3 || remainder == 6 || remainder == 9) {
                count += 1;
            }
            number /= 10;
        }

        return count;
    }
}
