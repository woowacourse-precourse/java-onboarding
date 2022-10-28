package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 숫자의 각 자릿수를 나누는 함수
     * ex) 123 -> [3, 2, 1]
     */
    private static int[] splitDigit(int num) {
        int rest = num / 10;
        int place1 = num % 10;
        int place2 = rest % 10;
        int place3 = rest / 10;

        return new int[]{place1, place2, place3};
    }

    /**
     * (요구사항 2번 및 요구사항 3번)
     * 페이지의 각 자릿수를 더하는 함수
     */
    private static int getPageDigitSum(int[] splitedPage) {
        return Integer.MAX_VALUE;
    }

    /**
     * (요구사항 2번 및 요구사항 3번)
     * 페이지의 각 자릿수를 곱하는 함수
     */
    private static int getPageDigitMul(int[] splitedPage) {
        return Integer.MAX_VALUE;
    }

    /**
     * (요구사항 4번)
     * 플레이어의 점수를 계산하는 함수
     */
    private static int getScore(List<Integer> pageList) {
        return Integer.MAX_VALUE;
    }

    /**
     * (요구사항 6번)
     * 입력받은 페이지가 유효한지 확인하는 함수
     */
    private static boolean checkPagesValidation(List<Integer> pageList) {
        return false;
    }

    /**
     *  (요구사항 5번)
     *  점수를 비교해 승자를 구분하고 게임 결과를 반환하는 함수
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}