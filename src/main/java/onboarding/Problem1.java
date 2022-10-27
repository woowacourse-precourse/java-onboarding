package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isValidLeftPage(List<Integer> pages) {
        int leftPage = getLeftPage(pages);
        // 왼쪽 페이지가 문제에서 요구하는 페이지 범위 외의 값이거나 짝수인 경우 유효하지 않은 입력
        if (leftPage <= 1 || leftPage >= 399 || leftPage % 2 == 0) {
            return false;
        }

        return true;
    }

    private static boolean isValidRightPage(List<Integer> pages) {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);
        // 오른쪽 페이지가 왼쪽 페이지와 연속하지 않은 경우 유효하지 않은 입력 이렇게 검증 시 나머지의 경우는 왼쪽 페이지에서 검증됨
        int validRightPage = leftPage + 1;
        if (rightPage != validRightPage) {
            return false;
        }

        return true;
    }

    private static boolean isValidPage(List<Integer> pages) {
        if (!isValidLeftPage(pages) || !isValidRightPage(pages)) {
            return false;
        }
        return true;
    }

    private static int getLeftPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        return leftPage;
    }

    private static int getRightPage(List<Integer> pages) {
        int rightPage = pages.get(1);
        return rightPage;
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

    private static int getNumsSum(List<Integer> splitNums) {
        int sum = splitNums.stream()
                .reduce(0, Integer::sum);

        return sum;
    }

    private static int getNumsMultiplication(List<Integer> splitNums) {
        int multiplication = splitNums.stream()
                .reduce(1, (a, b) -> a * b);

        return multiplication;
    }


    private static int getPageScore(int page) {
        List<Integer> splitNums = getSplitNums(page);

        int sum = getNumsSum(splitNums);
        int multiplication = getNumsMultiplication(splitNums);
        int pageScore = Math.max(sum, multiplication);

        return pageScore;
    }

    private static int getScoreByUserPages(List<Integer> userPages) {
        int leftPage = getLeftPage(userPages);
        int rightPage = getRightPage(userPages);

        int leftPageScore = getPageScore(leftPage);
        int rightPageScore = getPageScore(rightPage);
        int userScore = Math.max(leftPageScore, rightPageScore);

        return userScore;
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

    static class Answers {
        private final Map<String,Integer> answers;

        public Answers(Map<String, Integer> answers) {
            this.answers = answers;
        }

        public int getAnswerByGameResult(String gameResult) {
            return answers.get(gameResult);
        }
    }

}
