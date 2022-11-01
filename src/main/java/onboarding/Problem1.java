package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem = new Problem1();
        boolean checkPobiException = problem.findException(pobi);
        boolean checkCrongException = problem.findException(crong);
        if (!checkPobiException || !checkCrongException) {
            return -1;
        } else {
            int pobiScore = problem.getScore(pobi);
            int crongScore = problem.getScore(crong);

            return problem.compareScore(pobiScore, crongScore);
        }
    }

    public int getScore(List<Integer> pages) {
        List<Integer> pageScores = pages.stream().map(this::getEachPageScore).collect(Collectors.toList());
        return Collections.max(pageScores);
    }

    public int compareScore(int score1, int score2) {
        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        } else return 0;
    }

    public boolean findException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (leftPage % 2 == 1 && rightPage == leftPage + 1) {
            return leftPage > 1 && rightPage < 400;
        } else {
            return false;
        }
    }

    public int getEachPageScore(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        while(num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
        int multipleDigits = digits.stream().reduce(1, (acc, cur) -> acc * cur);
        int sumDigits = digits.stream().reduce(0, Integer::sum);
        return Math.max(multipleDigits, sumDigits);
    }
}