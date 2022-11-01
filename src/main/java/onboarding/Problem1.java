package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    /*
    기능요구사항
    1. 포비와 크롱이 각각 펼친 페이지의 숫자들을 규칙에 따라 계산한다.
        1.1 이 때 나올수 없는 경우의 페이지거나 시작면/마지막면을 펼쳤을 경우가 입력으로 주어지면 예외처리를 하고종료한다.
    2. 계산된 점수에 다라 승패를 가른다.
    * */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Compute(pobi,crong);
        return answer;
    }

    private static void Compute(List<Integer> pobi, List<Integer> crong) {

        if(FaultPageException(pobi,crong))  System.out.println(-1);


    }

    private static boolean FaultPageException(List<Integer> pobi, List<Integer> crong) {
        /*왼쪽 페이지가 홀수가 아니거나 오른쪽 페이지가 짝수가 아니거나
            양쪽 페이지의 차이가 1이 아닌 경우.
        * */
        if(pobi.get(0)%2 != 1 || pobi.get(1) %2 != 0 || Math.abs(pobi.get(0)-pobi.get(1)) !=1 ) return true;
        if(crong.get(0)%2 != 1 || crong.get(1) %2 != 0 && Math.abs(crong.get(0)-crong.get(1)) !=1 ) return true;
        return false;
    }

}