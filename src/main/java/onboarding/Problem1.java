package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isCorrectCondition(pobi) && isCorrectCondition(crong)) {
            answer = 1;
        } else {
            answer = -1;
        }

        return answer;
    }

    public static boolean isCorrectCondition(List<Integer> pageNumbers) {
        int leftPageNumber = pageNumbers.get(0);
        int rightPageNumber = pageNumbers.get(1);

        if (leftPageNumber < 1 || 400 < leftPageNumber || rightPageNumber < 1 || 400 < rightPageNumber) {
            return false;
        }
        if ((leftPageNumber + 1) != rightPageNumber) {
            return false;
        }
        if (leftPageNumber % 2 != 1) {
            return false;
        }

        return true;
    }

    public static int getSumOfEachDigit(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}