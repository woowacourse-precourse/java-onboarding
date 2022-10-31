package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            answer += count369byNumber(i);
        }

        return answer;
    }

    public static int count369byNumber(int number) {
        int count = 0;

        while (number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count += 1;
            }
            number /= 10;
        }

        return count;
    }
}
