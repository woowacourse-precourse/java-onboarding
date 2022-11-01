package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 0; i < number; i++) {
            answer += game369(number);
        }
        return answer;
    }

    private static int game369(int number) {
        int answer = 0;
        while (number > 0) {
            int target = number % 10;
            if (target == 3 || target == 6 || target == 9) {
                answer++;
            }
            number /= 10;
        }
        return answer;
    }
}
