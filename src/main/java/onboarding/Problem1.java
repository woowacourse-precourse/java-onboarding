package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int invalidInput = -1;
        if (!isValidPage(pobi) || !isValidPage(crong)) {
            return invalidInput;
        }

        int pobiScore = getUserScoreByPages(pobi);
        int crongScore = getUserScoreByPages(crong);
        String result = getGameResultByScores(pobiScore, crongScore);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("pobi win", 1);
        resultMap.put("crong win", 2);
        resultMap.put("draw", 0);
        GameResult answers = new GameResult(resultMap);

        return answers.getAnswerByGameResult(result);
    }

    static class GameResult {
        private final Map<String, Integer> gameResult;

        public GameResult(Map<String, Integer> gameResult) {
            this.gameResult = gameResult;
        }

        public int getAnswerByGameResult(String gameResult) {
            return this.gameResult.get(gameResult);
        }
    }

    private static boolean isValidPage(List<Integer> pages) {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);
        int validRightPage = leftPage + 1;

        if ((leftPage > 1) && (leftPage < 399)
                && (leftPage % 2 == 1) && (rightPage == validRightPage)) {
            return true;
        }
        return false;
    }

    private static int getUserScoreByPages(List<Integer> userPages) {
        int leftPage = getLeftPage(userPages);
        int rightPage = getRightPage(userPages);

        int leftPageScore = getPageScore(leftPage);
        int rightPageScore = getPageScore(rightPage);

        return Math.max(leftPageScore, rightPageScore);
    }

    private static List<Integer> getSplitNums(int page) {
        List<Integer> splitNums = new ArrayList<>();

        while (page > 0) {
            int splitNum = page % 10;
            splitNums.add(splitNum);

            page = page / 10;
        }

        return splitNums;
    }

    private static int getLeftPage(List<Integer> pages) {
        return pages.get(0);
    }

    private static int getRightPage(List<Integer> pages) {
        return pages.get(1);
    }

    private static int getNumsSum(List<Integer> splitNums) {
        return splitNums.stream()
                .reduce(0, Integer::sum);
    }

    private static int getNumsMultiplication(List<Integer> splitNums) {
        return splitNums.stream()
                .reduce(1, (a, b) -> a * b);
    }

    private static int getPageScore(int page) {
        List<Integer> splitNums = getSplitNums(page);

        int sum = getNumsSum(splitNums);
        int multiplication = getNumsMultiplication(splitNums);
        return Math.max(sum, multiplication);
    }

    private static String getGameResultByScores(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return "pobi win";
        }
        if (crongScore > pobiScore) {
            return "crong win";
        }
        return "draw";
    }
}
