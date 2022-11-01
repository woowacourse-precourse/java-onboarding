package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isCorrectCondition(pobi) && isCorrectCondition(crong)) {
            int pobiScore = calculateScore(pobi);
            int crongScore = calculateScore(crong);

            answer = calculateWinner(pobiScore, crongScore);
        } else {
            answer = -1;
        }

        return answer;
    }

    private static int calculateWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
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

    public static int calculateScore(List<Integer> pageNumbers) {
        int score = 0;

        int leftPageNumber = pageNumbers.get(0);
        int rightPageNumber = pageNumbers.get(1);

        List<Integer> scores = new ArrayList<>();

        scores.add(getSumOfEachDigit(leftPageNumber));
        scores.add(getSumOfEachDigit(rightPageNumber));
        scores.add(getMultiplyOfEachDigit(leftPageNumber));
        scores.add(getMultiplyOfEachDigit(rightPageNumber));

        score = Collections.max(scores);

        return score;
    }

    public static int getSumOfEachDigit(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static int getMultiplyOfEachDigit(int number) {
        int multiply = 1;

        while (number != 0) {
            multiply *= number % 10;
            number /= 10;
        }

        return multiply;
    }
}