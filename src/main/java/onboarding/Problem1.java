package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }


    /**
     * [예외 발생 확인 기능]
     * - 입력받은 페이지가 1~400사이인지 확인한다.
     * - 입력받은 페이지의 차가 1인지 확인한다.
     * - 입력받 데이터의 길이가 2인지 확인한다.
     * - 입력 받은 페이지에 예외가 발생하지 않는다면 True를 반환한다.
     */
    public boolean checkForExceptions(List<Integer> pobi, List<Integer> crong) {
        boolean returnValue = false;
        return returnValue;
    }


    /**
     * [점수 구하기 기능]
     * - 입력받은 두 페이지의 점수를 구한다.
     * - 점수는 각 자리를 모두 더하거나 모두 곱해 가장 큰 수 이다.
     * - 두 페이지의 점수 중 더 큰 수를 반환한다.
     */
    public int getScore(List<Integer> pobi, List<Integer> crong) {
        int returnValue = 1;
        return returnValue;
    }

    /**
     * [승자 구하기 기능]
     * - 포비와 크롱의 점수를 입력받는다.
     * - 포비의 점수가 항상 먼저 입력되어야한다.
     * - 더 큰 숫자가 승자가 된다.
     * - 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0을 반환한다.
     */
    public int getWinner(int pobiScore, int crongScore) {
        int returnValue = 1;
        return returnValue;
    }



}