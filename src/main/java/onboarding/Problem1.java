package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptionCheck(pobi) || exceptionCheck(crong)) {
            return -1;
        }
        List<Integer> scores = List.of(getScore(pobi), getScore(crong));
        return getWinner(scores);
    }

    /**
     * 예외사항 체크
     *
     * @param pages 양쪽 페이지의 번호
     * @return 예외사항의 유무
     */
    public static boolean exceptionCheck(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    /**
     * 게임의 승부 구하기
     *
     * @param scores 포비와 크롱의 점수
     * @return 승부 결과
     */
    public static int getWinner(List<Integer> scores) {
        int pobiScore = scores.get(0);
        int crongScore = scores.get(1);
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
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