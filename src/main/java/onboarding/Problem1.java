package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int addNumber(Integer number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int multiplyNumber(Integer number) {
        int result = 1;
        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getHighNumber(Integer number1, Integer number2) {
        return Math.max(number1, number2);
    }

    private static int getScore(Integer leftNumber, Integer rightNumber) {
        return getHighNumber(leftNumber, rightNumber);
    }
}
