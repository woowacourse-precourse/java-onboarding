package onboarding;

public class Problem3 {

    public static int solution(int number) {

        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException();
        }

        int answer = 0;

        for (int now = 1; now <= number; now++) {
            answer += getClapCount(now);
        }

        return answer;
    }

    private static int getClapCount(int number) {

        int count = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit % 3 == 0 && digit != 0) {
                count++;
            }

            number /= 10;
        }

        return count;
    }
}
