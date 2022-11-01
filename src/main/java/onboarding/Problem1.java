package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPage(pobi) || isInvalidPage(crong)) {
            return -1;
        }

        int pobiScore = findMaxScore(pobi);
        int crongScore = findMaxScore(crong);

        return computeScore(pobiScore, crongScore);
    }

    private static int computeScore(int pobiScore, int crongScore) {
        if (pobiScore == -1 || crongScore == -1) {
            return -1;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }

    private static boolean isInvalidPage(List<Integer> openPage) {
        int leftPage = openPage.get(0);
        int rightPage = openPage.get(1);

        if (openPage.size() != 2) {
            return true;
        }
        if (leftPage <= 1 || leftPage >= 399) {
            return true;
        }
        if (rightPage <= 2 || rightPage >= 400) {
            return true;
        }
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return true;
        }
        if (leftPage + 1 != rightPage) {
            return true;
        }

        return false;
    }

    private static int findMaxScore(List<Integer> openPage) {
        return openPage.stream()
                .mapToInt(Problem1::countPageScore)
                .max()
                .orElseGet(() -> -1);
    }

    private static int countPageScore(int page) {
        int plusNum = 0;
        int multipleNum = 1;

        while (page > 0) {
            plusNum += (page % 10);
            multipleNum *= (page % 10);

            page /= 10;
        }

        return Math.max(plusNum, multipleNum);
    }
}