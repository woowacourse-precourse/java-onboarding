package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (checkForException(pobi,crong)){
            answer = getWinner(getScore(pobi),getScore(crong));
        }else {
            answer = -1;
        }
        return answer;
    }




    /**
     * [예외 발생 확인 기능]
     * - 입력받은 페이지가 1~400사이인지 확인한다.
     * - 입력받은 페이지의 차가 1인지 확인한다.
     * - 입력받은 데이터의 길이가 2인지 확인한다.
     * - 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인한다.
     * - 입력 받은 페이지에 예외가 발생하지 않는다면 True를 반환한다.
     */
    public static boolean checkForException(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.size() == 2 && crong.size() == 2) &&
                (pobi.get(0) % 2 == 1 && crong.get(0) % 2 == 1 && pobi.get(1) % 2 == 0 && crong.get(1) % 2 == 0)&&
                (pobi.get(1)-pobi.get(0) == 1 && crong.get(1)-crong.get(0) == 1) &&
                (0 < pobi.get(0) && pobi.get(0) <= 400  && 0 < pobi.get(1) && pobi.get(1) <= 400) &&
                (0 < crong.get(0) && crong.get(0) <= 400  && 0 < crong.get(1) && crong.get(1) <= 400)) {
            return true;
        }else {
            return false;
        }
    }


    /**
     * [점수 구하기 기능]
     * - 입력받은 두 페이지의 점수를 구한다.
     * - 점수는 각 자리를 모두 더하거나 모두 곱해 가장 큰 수 이다.
     * - 두 페이지의 점수 중 더 큰 수를 반환한다.
     */
    public static int getScore(List<Integer> pageList) {
        int maxValue = -1;
        for (int page:pageList) {
            String sPage = Integer.toString(page);
            int plusValue = 0;
            int multipliedValue = 1;
            for (int i = 0 ; i < sPage.length(); i++) {
                plusValue += Character.getNumericValue(sPage.charAt(i));
                multipliedValue *= Character.getNumericValue(sPage.charAt(i));
            }
            if (multipliedValue > maxValue) {
                maxValue = multipliedValue;
            }else if (plusValue > maxValue){
                maxValue = plusValue;
            }
        }
        return maxValue;
    }

    /**
     * [승자 구하기 기능]
     * - 포비와 크롱의 점수를 입력받는다.
     * - 포비의 점수가 항상 먼저 입력되어야한다.
     * - 더 큰 숫자가 승자가 된다.
     * - 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0을 반환한다.
     */
    public static int getWinner(int pobiScore, int crongScore) {
        int winner = -1;
        if (pobiScore > crongScore) {
            winner = 1;
        }else if (pobiScore < crongScore){
            winner = 2;
        }else if (pobiScore == crongScore) {
            winner = 0;
        }
        return winner;
    }



}