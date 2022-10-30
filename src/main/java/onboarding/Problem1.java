package onboarding;

import java.util.List;

/**
 * isCorrectPages 메서드 입력받은 페이지값이 올바른지 확인
 * getSumOfPages 메서드 페이지의 각자리수의 합을 반환
 * getMultiplyOfPages 메서드 페이지의 각자리수의 곱을 반환
 * getMaxOfPages 메서드 페이지의 각자리수 합과 곱 중 더 큰값을 반환
 * compareOfResult 메서드 값을 비교하여 승자를 반환
 */

class Problem1 {
    private static final int DRAW = 0;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int EXCEPTION = -1;

    private static int maxScoreOfPobi;
    private static int maxScoreOfCrong;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isCorrectPages(List<Integer> pages) {
        return (pages.get(RIGHT_PAGE) - pages.get(LEFT_PAGE) == 1);
    }

}
