package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; ++i) {
            answer += getThreeSixNineRecursive(i);
        }
        return answer;
    }

    private static int getThreeSixNineRecursive(int num) {
        if (num == 0) {
            return 0;
        }

        int value = num % 10;
        int result = 0;

        if (value == 3 || value == 6 || value == 9) {
            result = 1;
        }

        num /= 10;

        return result + getThreeSixNineRecursive(num);
    }
}
