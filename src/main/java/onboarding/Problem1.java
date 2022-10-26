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

    private static int getHighResult(Integer number) {
        int addResult = addNumber(number);
        int multiplyResult = multiplyNumber(number);
        return Math.max(addResult, multiplyResult);
    }

    private static int getScore(List<Integer> numberList) {
        int leftHighResult = getHighResult(numberList.get(0));
        int rightHighResult = getHighResult(numberList.get(1));
        return Math.max(leftHighResult, rightHighResult);
    }

    private static boolean checkNumberListValidation(List<Integer> numberList) {
        return numberList.get(0) % 2 == 1 && numberList.get(1) - numberList.get(0) == 1;
    }

    private static int getWinner(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
            return 1;
        } else if (leftScore < rightScore) {
            return 2;
        } else {
            return 0;
        }
    }
}
