package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if (!isValidPages(pobi) || !isValidPages(crong)) return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = getResult(pobiScore, crongScore);

        return answer;
    }

    private static boolean isValidPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage >= rightPage) return false;
        if (leftPage < 1) return false;
        if (rightPage > 400) return false;
        if (leftPage % 2 != 1) return false;
        if (rightPage % 2 != 0) return false;
        if (leftPage + 1 != rightPage) return false;

        return true;
    }

    private static int calculateScore(int page) {
        int score;
        int scoreBySum = 0;
        int scoreByMultiplication = 1;
        List<Integer> numberList = new ArrayList<>();

        String numberString = String.valueOf(page);
        Arrays.stream(numberString.split(""))
                .mapToInt(Integer::parseInt)
                .forEach(numberList::add);

        for (int number : numberList) {
            scoreBySum += number;
            scoreByMultiplication *= number;
        }

        score = Math.max(scoreBySum, scoreByMultiplication);

        return score;
    }

    private static int getScore(List<Integer> pages) {
        int score = 0;

        for (int page : pages) {
            score = Math.max(score, calculateScore(page));
        }

        return score;
    }

    private static int getResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }
}
