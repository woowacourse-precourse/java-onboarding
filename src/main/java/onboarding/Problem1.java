package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int calculateScore(List<Integer> pageNumbers) {
        int leftPageMaxNumber = makePageMaxNumber(pageNumbers.get(0));
        int rightPageMaxNumber = makePageMaxNumber(pageNumbers.get(1));

        int score = Math.max(leftPageMaxNumber, rightPageMaxNumber);

        return score;
    }

    public List<Integer> splitNumbers(int pageNumber) {
        List<Integer> numbers = new ArrayList<>();

        if (pageNumber/100 >= 1) {
            numbers.add(pageNumber/100);
            pageNumber = pageNumber % 100;
        }

        if (pageNumber/10 >=1) {
            numbers.add(pageNumber/10);
        }

        numbers.add(pageNumber%10);

        return numbers;
    }

    public int makePageMaxNumber(int pageNumber) {
        List<Integer> splitNumbers = splitNumbers(pageNumber);

        int sumOfAllDigits = 0;
        int mulOfAllDigits = 1;

        for (int n : splitNumbers) {
            sumOfAllDigits += n;
            mulOfAllDigits *= n;
        }

        return Math.max(sumOfAllDigits, mulOfAllDigits);
    }

    public int decideWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }
}