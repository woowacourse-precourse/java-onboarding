package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<Integer>(Arrays.asList(1,2));
        ArrayList<Integer> test2 = new ArrayList<Integer>(Arrays.asList(4,6));
        System.out.println(checkForException(test2,test1));
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }




    /**
     * [예외 발생 확인 기능]
     * - 입력받은 페이지가 1~400사이인지 확인한다.
     * - 입력받은 페이지의 차가 1인지 확인한다.
     * - 입력받은 데이터의 길이가 2인지 확인한다.
     * - 입력 받은 페이지에 예외가 발생하지 않는다면 True를 반환한다.
     */
    public static boolean checkForException(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.size() == 2 && crong.size() == 2) &&
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