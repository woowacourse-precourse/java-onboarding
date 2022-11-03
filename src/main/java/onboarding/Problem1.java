package onboarding;

import java.util.List;
import java.util.stream.Stream;

/**
 * 기능 1: 올바른 페이지 수가 입력되었는가 확인
 * 기능 2: 각각 개별로 최대로 얻은 점수를 최고 점수로 구하기
 * 기능 3: 두 명의 점수를 비교하여 승패 가르기
 */
class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static boolean isEvenPage(int pageNumber) {
        return pageNumber % 2 == 0;
    }

    private static boolean validatePage(List<Integer> pages) {

        int left = pages.get(0), right = pages.get(1);

        if (left < 1 || right > 400) {
            return false;
        }

        if (isEvenPage(left) || !isEvenPage(right)) {
            return false;
        }

        if (left > right) {
            return false;
        }

        if (Math.abs(left - right) != 1) {
            return false;
        }
        return true;
    }

    public static int findMaxScoreHelper(int left, int right) {
        int[] leftNumArr = Stream.of(String.valueOf(left).split("")).mapToInt(Integer::parseInt).toArray();
        int[] rightNumArr = Stream.of(String.valueOf(right).split("")).mapToInt(Integer::parseInt).toArray();

        return Math.max(findMaxScore(leftNumArr), findMaxScore(rightNumArr));
    }

    public static int findMaxScore(int[] numArr) {
        int addSum = 0, multiSum = 1;

        for (int num : numArr) {
            addSum += num;
            multiSum *= num;
        }

        return Math.max(addSum, multiSum);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePage(pobi) || !validatePage(crong)) {
            return EXCEPTION;
        }

        int pobiScore = findMaxScoreHelper(pobi.get(0), pobi.get(1));
        int crongScore = findMaxScoreHelper(crong.get(0), crong.get(1));

        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}