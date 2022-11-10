package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += clap(i);
        }

        return answer;
    }

    public static int clap(int number) {
        int result = 0;
        while (number > 0) {
            int current = number % 10;
            if (current == 3 || current == 6 || current == 9) {
                result += 1;
            }
            number /= 10;
        }
        return result;
    }
}
