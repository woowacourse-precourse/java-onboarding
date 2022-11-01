package onboarding;

public class Problem3 {
    private static int countNumber369(int number) {
        int count369 = 0;
        while (number > 0) {
            if (is369(number % 10)) {
                count369++;
            }
            number /= 10;
        }
        return count369;
    }

    private static boolean is369(int number) {
        return (number == 3 || number == 6 || number == 9);
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countNumber369(i);
        }

        return answer;
    }
}
