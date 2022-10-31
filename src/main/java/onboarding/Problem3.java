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
        int answer = 0;
        while (number > 0) {
            int digitNumber = number % 10;
            if (digitNumber == 3 || digitNumber == 6 || digitNumber == 9) {
                answer++;
            }
            number /= 10;
        }
        return answer;
    }
}
