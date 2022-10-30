package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    private static final int PAGE_EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WINNER = 1;
    private static final int CRONG_WINNER = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPageException(pobi) || isPageException(crong)) {
            return PAGE_EXCEPTION;
        }
        List<Integer> scores = List.of(getScore(pobi), getScore(crong));
        return getResult(scores);
    }

    /**
     * 페이지에 대한 예외사항을 확인한다.
     *
     * @param pages 양쪽 페이지의 번호
     * @return 예외사항이 있으면 true 를 반환한다.
     */
    private static boolean isPageException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if(rightPage - leftPage != 1) {
            return true;
        }
        return leftPage < 1 || rightPage > 400;
    }

    /**
     * 게임의 승부를 구한다.
     *
     * @param scores 포비와 크롱의 점수
     * @return 포피가 이기면 1, 크롱이 이기면 2, 비기면 0을 반환한다.
     */
    private static int getResult(List<Integer> scores) {
        int pobiScore = scores.get(0);
        int crongScore = scores.get(1);
        if (pobiScore > crongScore) {
            return POBI_WINNER;
        } else if (pobiScore < crongScore) {
            return CRONG_WINNER;
        }
        return DRAW;
    }

    /**
     * 본인의 점수 구한다.
     *
     * @param pages 양쪽 페이지의 번호
     * @return 본인의 점수중 가장 높은 점수를 반환한다.
     */
    private static int getScore(List<Integer> pages) {
        int score = 0;
        int[][] pageNumber = new int[2][0];
        pageNumber[0] = Stream.of(String.valueOf(pages.get(0)).split("")).mapToInt(Integer::parseInt).toArray();
        pageNumber[1] = Stream.of(String.valueOf(pages.get(1)).split("")).mapToInt(Integer::parseInt).toArray();
        for (int[] page : pageNumber) {
            int mul = 1;
            int add = 0;
            for (int number : page) {
                mul *= number;
                add += number;
            }
            score = Math.max(score, Math.max(mul, add));
        }
        return score;
    }
}