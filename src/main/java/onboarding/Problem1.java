package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();

        try {
            if ((pobi.size() != 2) || (crong.size() != 2)) {
                throw new Exception();
            }

            int pobiScore = problem1.calculateScore(pobi);
            int crongScore = problem1.calculateScore(crong);

            int answer = problem1.decideWinner(pobiScore, crongScore);

            return answer;
        } catch (Exception e) {
            return -1;
        }
    }

    public int calculateScore(List<Integer> pageNumbers) throws Exception {
        if ((pageNumbers.get(0) % 2 == 0) || (pageNumbers.get(1) % 2 == 1)) {
            throw new Exception();
        } else if ((pageNumbers.get(1) - pageNumbers.get(0)) != 1) {
            throw new Exception();
        }

        int leftPageMaxNumber = makePageMaxNumber(pageNumbers.get(0));
        int rightPageMaxNumber = makePageMaxNumber(pageNumbers.get(1));

        int score = Math.max(leftPageMaxNumber, rightPageMaxNumber);

        return score;
    }

    public List<Integer> splitNumbers(int pageNumber) {
        List<Integer> numbers = new ArrayList<>();

        if ((pageNumber / 100) >= 1) {
            numbers.add(pageNumber/100);
            pageNumber = pageNumber % 100;
        }

        if ((pageNumber / 10) >= 1) {
            numbers.add(pageNumber / 10);
        }

        numbers.add(pageNumber % 10);

        return numbers;
    }

    public int makePageMaxNumber(int pageNumber) throws Exception {
        if (pageNumber < 1 || pageNumber > 400) {
            throw new Exception();
        }

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