package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static final int PAGE_EXCEPTION = -1;
    public static final int DRAW = 0;
    public static final int POBI_WINNER = 1;
    public static final int CRONG_WINNER = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPageException(pobi) || isPageException(crong)) {
            return PAGE_EXCEPTION;
        }
        List<Integer> scores = List.of(getScore(pobi), getScore(crong));
        return getResult(scores);
    }

    /**
     * 예외사항 체크
     *
     * @param pages 양쪽 페이지의 번호
     * @return 예외사항의 유무
     */
    public static boolean isPageException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if(rightPage - leftPage != 1) {
            return true;
        }
        return leftPage < 1 || rightPage > 400;
    }

    /**
     * 게임의 승부 구하기
     *
     * @param scores 포비와 크롱의 점수
     * @return 승부 결과
     */
    public static int getResult(List<Integer> scores) {
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
     * 본인의 점수 구하기
     *
     * @param pages 양쪽 페이지의 번호
     * @return 본인의 점수
     */
    public static int getScore(List<Integer> pages) {
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